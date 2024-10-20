
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 项目图纸
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiangmuTuzhi")
public class XiangmuTuzhiController {
    private static final Logger logger = LoggerFactory.getLogger(XiangmuTuzhiController.class);

    private static final String TABLE_NAME = "xiangmuTuzhi";

    @Autowired
    private XiangmuTuzhiService xiangmuTuzhiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CailiaocankaoService cailiaocankaoService;//材料参考
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JianzaocaiwuService jianzaocaiwuService;//监造财务
    @Autowired
    private JianzaojinduService jianzaojinduService;//监造进度
    @Autowired
    private JingfeiyuguService jingfeiyuguService;//经费预估
    @Autowired
    private XiangmuService xiangmuService;//项目
    @Autowired
    private YanshouCailiaoService yanshouCailiaoService;//材料验收
    @Autowired
    private YanshouChengguoService yanshouChengguoService;//成果验收
    @Autowired
    private YanshouGongyiService yanshouGongyiService;//工艺验收
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = xiangmuTuzhiService.queryPage(params);

        //字典表数据转换
        List<XiangmuTuzhiView> list =(List<XiangmuTuzhiView>)page.getList();
        for(XiangmuTuzhiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiangmuTuzhiEntity xiangmuTuzhi = xiangmuTuzhiService.selectById(id);
        if(xiangmuTuzhi !=null){
            //entity转view
            XiangmuTuzhiView view = new XiangmuTuzhiView();
            BeanUtils.copyProperties( xiangmuTuzhi , view );//把实体数据重构到view中
            //级联表 项目
            //级联表
            XiangmuEntity xiangmu = xiangmuService.selectById(xiangmuTuzhi.getXiangmuId());
            if(xiangmu != null){
            BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXiangmuId(xiangmu.getId());
            }
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(xiangmuTuzhi.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmuTuzhiEntity xiangmuTuzhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiangmuTuzhi:{}",this.getClass().getName(),xiangmuTuzhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            xiangmuTuzhi.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XiangmuTuzhiEntity> queryWrapper = new EntityWrapper<XiangmuTuzhiEntity>()
            .eq("xiangmu_id", xiangmuTuzhi.getXiangmuId())
            .eq("yuangong_id", xiangmuTuzhi.getYuangongId())
            .eq("xiangmu_tuzhi_name", xiangmuTuzhi.getXiangmuTuzhiName())
            .eq("xiangmu_tuzhi_types", xiangmuTuzhi.getXiangmuTuzhiTypes())
            .in("xiangmu_tuzhi_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmuTuzhiEntity xiangmuTuzhiEntity = xiangmuTuzhiService.selectOne(queryWrapper);
        if(xiangmuTuzhiEntity==null){
            xiangmuTuzhi.setInsertTime(new Date());
            xiangmuTuzhi.setXiangmuTuzhiYesnoTypes(1);
            xiangmuTuzhi.setCreateTime(new Date());
            xiangmuTuzhiService.insert(xiangmuTuzhi);
            return R.ok();
        }else {
            if(xiangmuTuzhiEntity.getXiangmuTuzhiYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(xiangmuTuzhiEntity.getXiangmuTuzhiYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiangmuTuzhiEntity xiangmuTuzhi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xiangmuTuzhi:{}",this.getClass().getName(),xiangmuTuzhi.toString());
        XiangmuTuzhiEntity oldXiangmuTuzhiEntity = xiangmuTuzhiService.selectById(xiangmuTuzhi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            xiangmuTuzhi.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(xiangmuTuzhi.getXiangmuTuzhiFile()) || "null".equals(xiangmuTuzhi.getXiangmuTuzhiFile())){
                xiangmuTuzhi.setXiangmuTuzhiFile(null);
        }
        if("".equals(xiangmuTuzhi.getXiangmuTuzhiContent()) || "null".equals(xiangmuTuzhi.getXiangmuTuzhiContent())){
                xiangmuTuzhi.setXiangmuTuzhiContent(null);
        }
        if("".equals(xiangmuTuzhi.getXiangmuTuzhiYesnoText()) || "null".equals(xiangmuTuzhi.getXiangmuTuzhiYesnoText())){
                xiangmuTuzhi.setXiangmuTuzhiYesnoText(null);
        }

            xiangmuTuzhiService.updateById(xiangmuTuzhi);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody XiangmuTuzhiEntity xiangmuTuzhiEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,xiangmuTuzhiEntity:{}",this.getClass().getName(),xiangmuTuzhiEntity.toString());

        XiangmuTuzhiEntity oldXiangmuTuzhi = xiangmuTuzhiService.selectById(xiangmuTuzhiEntity.getId());//查询原先数据

//        if(xiangmuTuzhiEntity.getXiangmuTuzhiYesnoTypes() == 2){//通过
//            xiangmuTuzhiEntity.setXiangmuTuzhiTypes();
//        }else if(xiangmuTuzhiEntity.getXiangmuTuzhiYesnoTypes() == 3){//拒绝
//            xiangmuTuzhiEntity.setXiangmuTuzhiTypes();
//        }

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            xiangmuTuzhiEntity.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        xiangmuTuzhiEntity.setXiangmuTuzhiShenheTime(new Date());//审核时间
        xiangmuTuzhiService.updateById(xiangmuTuzhiEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XiangmuTuzhiEntity> oldXiangmuTuzhiList =xiangmuTuzhiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xiangmuTuzhiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<XiangmuTuzhiEntity> xiangmuTuzhiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XiangmuTuzhiEntity xiangmuTuzhiEntity = new XiangmuTuzhiEntity();
//                            xiangmuTuzhiEntity.setXiangmuId(Integer.valueOf(data.get(0)));   //项目 要改的
//                            xiangmuTuzhiEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            xiangmuTuzhiEntity.setXiangmuTuzhiUuidNumber(data.get(0));                    //图纸编号 要改的
//                            xiangmuTuzhiEntity.setXiangmuTuzhiName(data.get(0));                    //图纸名称 要改的
//                            xiangmuTuzhiEntity.setXiangmuTuzhiFile(data.get(0));                    //图纸文件 要改的
//                            xiangmuTuzhiEntity.setXiangmuTuzhiTypes(Integer.valueOf(data.get(0)));   //图纸类型 要改的
//                            xiangmuTuzhiEntity.setXiangmuTuzhiContent("");//详情和图片
//                            xiangmuTuzhiEntity.setInsertTime(date);//时间
//                            xiangmuTuzhiEntity.setXiangmuTuzhiYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            xiangmuTuzhiEntity.setXiangmuTuzhiYesnoText(data.get(0));                    //审核回复 要改的
//                            xiangmuTuzhiEntity.setXiangmuTuzhiShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            xiangmuTuzhiEntity.setCreateTime(date);//时间
                            xiangmuTuzhiList.add(xiangmuTuzhiEntity);


                            //把要查询是否重复的字段放入map中
                                //图纸编号
                                if(seachFields.containsKey("xiangmuTuzhiUuidNumber")){
                                    List<String> xiangmuTuzhiUuidNumber = seachFields.get("xiangmuTuzhiUuidNumber");
                                    xiangmuTuzhiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiangmuTuzhiUuidNumber = new ArrayList<>();
                                    xiangmuTuzhiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xiangmuTuzhiUuidNumber",xiangmuTuzhiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //图纸编号
                        List<XiangmuTuzhiEntity> xiangmuTuzhiEntities_xiangmuTuzhiUuidNumber = xiangmuTuzhiService.selectList(new EntityWrapper<XiangmuTuzhiEntity>().in("xiangmu_tuzhi_uuid_number", seachFields.get("xiangmuTuzhiUuidNumber")));
                        if(xiangmuTuzhiEntities_xiangmuTuzhiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiangmuTuzhiEntity s:xiangmuTuzhiEntities_xiangmuTuzhiUuidNumber){
                                repeatFields.add(s.getXiangmuTuzhiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [图纸编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xiangmuTuzhiService.insertBatch(xiangmuTuzhiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

