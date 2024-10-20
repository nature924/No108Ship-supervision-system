
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
 * 项目
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiangmu")
public class XiangmuController {
    private static final Logger logger = LoggerFactory.getLogger(XiangmuController.class);

    private static final String TABLE_NAME = "xiangmu";

    @Autowired
    private XiangmuService xiangmuService;


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
    private XiangmuTuzhiService xiangmuTuzhiService;//项目图纸
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
        PageUtils page = xiangmuService.queryPage(params);

        //字典表数据转换
        List<XiangmuView> list =(List<XiangmuView>)page.getList();
        for(XiangmuView c:list){
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
        XiangmuEntity xiangmu = xiangmuService.selectById(id);
        if(xiangmu !=null){
            //entity转view
            XiangmuView view = new XiangmuView();
            BeanUtils.copyProperties( xiangmu , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xiangmu.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody XiangmuEntity xiangmu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiangmu:{}",this.getClass().getName(),xiangmu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            xiangmu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XiangmuEntity> queryWrapper = new EntityWrapper<XiangmuEntity>()
            .eq("yonghu_id", xiangmu.getYonghuId())
            .eq("xiangmu_name", xiangmu.getXiangmuName())
            .eq("xiangmu_address", xiangmu.getXiangmuAddress())
            .eq("xiangmu_types", xiangmu.getXiangmuTypes())
            .eq("xiangmu_kucun_number", xiangmu.getXiangmuKucunNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmuEntity xiangmuEntity = xiangmuService.selectOne(queryWrapper);
        if(xiangmuEntity==null){
            xiangmu.setInsertTime(new Date());
            xiangmu.setCreateTime(new Date());
            xiangmuService.insert(xiangmu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiangmuEntity xiangmu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xiangmu:{}",this.getClass().getName(),xiangmu.toString());
        XiangmuEntity oldXiangmuEntity = xiangmuService.selectById(xiangmu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            xiangmu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(xiangmu.getXiangmuFile()) || "null".equals(xiangmu.getXiangmuFile())){
                xiangmu.setXiangmuFile(null);
        }
        if("".equals(xiangmu.getXiangmuContent()) || "null".equals(xiangmu.getXiangmuContent())){
                xiangmu.setXiangmuContent(null);
        }

            xiangmuService.updateById(xiangmu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XiangmuEntity> oldXiangmuList =xiangmuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xiangmuService.deleteBatchIds(Arrays.asList(ids));

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
            List<XiangmuEntity> xiangmuList = new ArrayList<>();//上传的东西
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
                            XiangmuEntity xiangmuEntity = new XiangmuEntity();
//                            xiangmuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xiangmuEntity.setXiangmuUuidNumber(data.get(0));                    //项目编号 要改的
//                            xiangmuEntity.setXiangmuName(data.get(0));                    //项目名称 要改的
//                            xiangmuEntity.setXiangmuAddress(data.get(0));                    //监造地点 要改的
//                            xiangmuEntity.setXiangmuFile(data.get(0));                    //建造资料 要改的
//                            xiangmuEntity.setXiangmuTypes(Integer.valueOf(data.get(0)));   //项目类型 要改的
//                            xiangmuEntity.setXiangmuKucunNumber(Integer.valueOf(data.get(0)));   //监造数量 要改的
//                            xiangmuEntity.setShenqingTime(sdf.parse(data.get(0)));          //申请时间 要改的
//                            xiangmuEntity.setNachuanTime(sdf.parse(data.get(0)));          //拿船时间 要改的
//                            xiangmuEntity.setXiangmuContent("");//详情和图片
//                            xiangmuEntity.setInsertTime(date);//时间
//                            xiangmuEntity.setCreateTime(date);//时间
                            xiangmuList.add(xiangmuEntity);


                            //把要查询是否重复的字段放入map中
                                //项目编号
                                if(seachFields.containsKey("xiangmuUuidNumber")){
                                    List<String> xiangmuUuidNumber = seachFields.get("xiangmuUuidNumber");
                                    xiangmuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiangmuUuidNumber = new ArrayList<>();
                                    xiangmuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xiangmuUuidNumber",xiangmuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //项目编号
                        List<XiangmuEntity> xiangmuEntities_xiangmuUuidNumber = xiangmuService.selectList(new EntityWrapper<XiangmuEntity>().in("xiangmu_uuid_number", seachFields.get("xiangmuUuidNumber")));
                        if(xiangmuEntities_xiangmuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiangmuEntity s:xiangmuEntities_xiangmuUuidNumber){
                                repeatFields.add(s.getXiangmuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [项目编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xiangmuService.insertBatch(xiangmuList);
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

