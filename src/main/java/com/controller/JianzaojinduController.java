
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
 * 监造进度
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jianzaojindu")
public class JianzaojinduController {
    private static final Logger logger = LoggerFactory.getLogger(JianzaojinduController.class);

    private static final String TABLE_NAME = "jianzaojindu";

    @Autowired
    private JianzaojinduService jianzaojinduService;


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
    private JingfeiyuguService jingfeiyuguService;//经费预估
    @Autowired
    private XiangmuService xiangmuService;//项目
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
        PageUtils page = jianzaojinduService.queryPage(params);

        //字典表数据转换
        List<JianzaojinduView> list =(List<JianzaojinduView>)page.getList();
        for(JianzaojinduView c:list){
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
        JianzaojinduEntity jianzaojindu = jianzaojinduService.selectById(id);
        if(jianzaojindu !=null){
            //entity转view
            JianzaojinduView view = new JianzaojinduView();
            BeanUtils.copyProperties( jianzaojindu , view );//把实体数据重构到view中
            //级联表 项目
            //级联表
            XiangmuEntity xiangmu = xiangmuService.selectById(jianzaojindu.getXiangmuId());
            if(xiangmu != null){
            BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXiangmuId(xiangmu.getId());
            }
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(jianzaojindu.getYuangongId());
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
    public R save(@RequestBody JianzaojinduEntity jianzaojindu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jianzaojindu:{}",this.getClass().getName(),jianzaojindu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            jianzaojindu.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JianzaojinduEntity> queryWrapper = new EntityWrapper<JianzaojinduEntity>()
            .eq("xiangmu_id", jianzaojindu.getXiangmuId())
            .eq("yuangong_id", jianzaojindu.getYuangongId())
            .eq("jianzaojindu_name", jianzaojindu.getJianzaojinduName())
            .eq("jianzaojindu_types", jianzaojindu.getJianzaojinduTypes())
            .eq("jianzaojindu_zhengchang_number", jianzaojindu.getJianzaojinduZhengchangNumber())
            .eq("jianzaojindu_xianzai_number", jianzaojindu.getJianzaojinduXianzaiNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianzaojinduEntity jianzaojinduEntity = jianzaojinduService.selectOne(queryWrapper);
        if(jianzaojinduEntity==null){
            jianzaojindu.setInsertTime(new Date());
            jianzaojindu.setCreateTime(new Date());
            jianzaojinduService.insert(jianzaojindu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianzaojinduEntity jianzaojindu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jianzaojindu:{}",this.getClass().getName(),jianzaojindu.toString());
        JianzaojinduEntity oldJianzaojinduEntity = jianzaojinduService.selectById(jianzaojindu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            jianzaojindu.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jianzaojindu.getJianzaojinduFile()) || "null".equals(jianzaojindu.getJianzaojinduFile())){
                jianzaojindu.setJianzaojinduFile(null);
        }
        if("".equals(jianzaojindu.getJianzaojinduContent()) || "null".equals(jianzaojindu.getJianzaojinduContent())){
                jianzaojindu.setJianzaojinduContent(null);
        }

            jianzaojinduService.updateById(jianzaojindu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JianzaojinduEntity> oldJianzaojinduList =jianzaojinduService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jianzaojinduService.deleteBatchIds(Arrays.asList(ids));

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
            List<JianzaojinduEntity> jianzaojinduList = new ArrayList<>();//上传的东西
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
                            JianzaojinduEntity jianzaojinduEntity = new JianzaojinduEntity();
//                            jianzaojinduEntity.setXiangmuId(Integer.valueOf(data.get(0)));   //项目 要改的
//                            jianzaojinduEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            jianzaojinduEntity.setJianzaojinduUuidNumber(data.get(0));                    //监造进度编号 要改的
//                            jianzaojinduEntity.setJianzaojinduName(data.get(0));                    //进度标题 要改的
//                            jianzaojinduEntity.setJianzaojinduTypes(Integer.valueOf(data.get(0)));   //进度类型 要改的
//                            jianzaojinduEntity.setJianzaojinduZhengchangNumber(Integer.valueOf(data.get(0)));   //正常进度(%) 要改的
//                            jianzaojinduEntity.setJianzaojinduXianzaiNumber(Integer.valueOf(data.get(0)));   //现在进度(%) 要改的
//                            jianzaojinduEntity.setJianzaojinduFile(data.get(0));                    //附件 要改的
//                            jianzaojinduEntity.setJianzaojinduTime(sdf.parse(data.get(0)));          //记录时间 要改的
//                            jianzaojinduEntity.setJianzaojinduContent("");//详情和图片
//                            jianzaojinduEntity.setInsertTime(date);//时间
//                            jianzaojinduEntity.setCreateTime(date);//时间
                            jianzaojinduList.add(jianzaojinduEntity);


                            //把要查询是否重复的字段放入map中
                                //监造进度编号
                                if(seachFields.containsKey("jianzaojinduUuidNumber")){
                                    List<String> jianzaojinduUuidNumber = seachFields.get("jianzaojinduUuidNumber");
                                    jianzaojinduUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jianzaojinduUuidNumber = new ArrayList<>();
                                    jianzaojinduUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jianzaojinduUuidNumber",jianzaojinduUuidNumber);
                                }
                        }

                        //查询是否重复
                         //监造进度编号
                        List<JianzaojinduEntity> jianzaojinduEntities_jianzaojinduUuidNumber = jianzaojinduService.selectList(new EntityWrapper<JianzaojinduEntity>().in("jianzaojindu_uuid_number", seachFields.get("jianzaojinduUuidNumber")));
                        if(jianzaojinduEntities_jianzaojinduUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JianzaojinduEntity s:jianzaojinduEntities_jianzaojinduUuidNumber){
                                repeatFields.add(s.getJianzaojinduUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [监造进度编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jianzaojinduService.insertBatch(jianzaojinduList);
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

