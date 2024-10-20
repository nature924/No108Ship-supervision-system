
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
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
 * 监造财务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jianzaocaiwu")
public class JianzaocaiwuController {
    private static final Logger logger = LoggerFactory.getLogger(JianzaocaiwuController.class);

    private static final String TABLE_NAME = "jianzaocaiwu";

    @Autowired
    private JianzaocaiwuService jianzaocaiwuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CailiaocankaoService cailiaocankaoService;//材料参考
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JianzaojinduService jianzaojinduService;//监造进度
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
        PageUtils page = jianzaocaiwuService.queryPage(params);

        //字典表数据转换
        List<JianzaocaiwuView> list =(List<JianzaocaiwuView>)page.getList();
        for(JianzaocaiwuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }



        params.put("limit","1000000");

        PageUtils page1 = jianzaocaiwuService.queryPage(params);
        List<JianzaocaiwuView> list1 =(List<JianzaocaiwuView>)page1.getList();
        BigDecimal sumJine=new BigDecimal(0.0);
        for(JianzaocaiwuView c:list1){
            sumJine=sumJine.add(new BigDecimal(c.getJianzaocaiwuZongjine()));
            System.out.println();
        }

        DecimalFormat df = new DecimalFormat("#0.00");
        R ok = R.ok();
        ok.put("data", page);
        ok.put("sumJine",df.format(sumJine));

        return ok;
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JianzaocaiwuEntity jianzaocaiwu = jianzaocaiwuService.selectById(id);
        if(jianzaocaiwu !=null){
            //entity转view
            JianzaocaiwuView view = new JianzaocaiwuView();
            BeanUtils.copyProperties( jianzaocaiwu , view );//把实体数据重构到view中
            //级联表 项目
            //级联表
            XiangmuEntity xiangmu = xiangmuService.selectById(jianzaocaiwu.getXiangmuId());
            if(xiangmu != null){
            BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXiangmuId(xiangmu.getId());
            }
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(jianzaocaiwu.getYuangongId());
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
    public R save(@RequestBody JianzaocaiwuEntity jianzaocaiwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jianzaocaiwu:{}",this.getClass().getName(),jianzaocaiwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            jianzaocaiwu.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JianzaocaiwuEntity> queryWrapper = new EntityWrapper<JianzaocaiwuEntity>()
            .eq("xiangmu_id", jianzaocaiwu.getXiangmuId())
            .eq("yuangong_id", jianzaocaiwu.getYuangongId())
            .eq("jianzaocaiwu_name", jianzaocaiwu.getJianzaocaiwuName())
            .eq("jianzaocaiwu_types", jianzaocaiwu.getJianzaocaiwuTypes())
            .eq("jianzaocaiwu_mingcheng", jianzaocaiwu.getJianzaocaiwuMingcheng())
            .eq("jianzaocaiwu_number", jianzaocaiwu.getJianzaocaiwuNumber())
            .eq("hege_types", jianzaocaiwu.getHegeTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianzaocaiwuEntity jianzaocaiwuEntity = jianzaocaiwuService.selectOne(queryWrapper);
        if(jianzaocaiwuEntity==null){
            jianzaocaiwu.setJianzaocaiwuZongjine(jianzaocaiwu.getJianzaocaiwuDanjia()*jianzaocaiwu.getJianzaocaiwuNumber());
            jianzaocaiwu.setInsertTime(new Date());
            jianzaocaiwu.setCreateTime(new Date());
            jianzaocaiwuService.insert(jianzaocaiwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianzaocaiwuEntity jianzaocaiwu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jianzaocaiwu:{}",this.getClass().getName(),jianzaocaiwu.toString());
        JianzaocaiwuEntity oldJianzaocaiwuEntity = jianzaocaiwuService.selectById(jianzaocaiwu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            jianzaocaiwu.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jianzaocaiwu.getJianzaojinduFile()) || "null".equals(jianzaocaiwu.getJianzaojinduFile())){
                jianzaocaiwu.setJianzaojinduFile(null);
        }
        if("".equals(jianzaocaiwu.getJianzaocaiwuContent()) || "null".equals(jianzaocaiwu.getJianzaocaiwuContent())){
                jianzaocaiwu.setJianzaocaiwuContent(null);
        }
        jianzaocaiwu.setJianzaocaiwuZongjine(jianzaocaiwu.getJianzaocaiwuDanjia()*jianzaocaiwu.getJianzaocaiwuNumber());

            jianzaocaiwuService.updateById(jianzaocaiwu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JianzaocaiwuEntity> oldJianzaocaiwuList =jianzaocaiwuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jianzaocaiwuService.deleteBatchIds(Arrays.asList(ids));

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
            List<JianzaocaiwuEntity> jianzaocaiwuList = new ArrayList<>();//上传的东西
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
                            JianzaocaiwuEntity jianzaocaiwuEntity = new JianzaocaiwuEntity();
//                            jianzaocaiwuEntity.setXiangmuId(Integer.valueOf(data.get(0)));   //项目 要改的
//                            jianzaocaiwuEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            jianzaocaiwuEntity.setJianzaocaiwuUuidNumber(data.get(0));                    //监造财务编号 要改的
//                            jianzaocaiwuEntity.setJianzaocaiwuName(data.get(0));                    //花费标题 要改的
//                            jianzaocaiwuEntity.setJianzaocaiwuTypes(Integer.valueOf(data.get(0)));   //消费类型 要改的
//                            jianzaocaiwuEntity.setJianzaojinduFile(data.get(0));                    //附件 要改的
//                            jianzaocaiwuEntity.setJianzaocaiwuMingcheng(data.get(0));                    //名称 要改的
//                            jianzaocaiwuEntity.setJianzaocaiwuDanjia(data.get(0));                    //单价 要改的
//                            jianzaocaiwuEntity.setJianzaocaiwuNumber(Integer.valueOf(data.get(0)));   //数量 要改的
//                            jianzaocaiwuEntity.setJianzaocaiwuZongjine(data.get(0));                    //应金额 要改的
//                            jianzaocaiwuEntity.setJianzaocaiwuShijiZongjine(data.get(0));                    //实际金额 要改的
//                            jianzaocaiwuEntity.setHegeTypes(Integer.valueOf(data.get(0)));   //是否合格 要改的
//                            jianzaocaiwuEntity.setJianzaocaiwuContent("");//详情和图片
//                            jianzaocaiwuEntity.setInsertTime(date);//时间
//                            jianzaocaiwuEntity.setCreateTime(date);//时间
                            jianzaocaiwuList.add(jianzaocaiwuEntity);


                            //把要查询是否重复的字段放入map中
                                //监造财务编号
                                if(seachFields.containsKey("jianzaocaiwuUuidNumber")){
                                    List<String> jianzaocaiwuUuidNumber = seachFields.get("jianzaocaiwuUuidNumber");
                                    jianzaocaiwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jianzaocaiwuUuidNumber = new ArrayList<>();
                                    jianzaocaiwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jianzaocaiwuUuidNumber",jianzaocaiwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //监造财务编号
                        List<JianzaocaiwuEntity> jianzaocaiwuEntities_jianzaocaiwuUuidNumber = jianzaocaiwuService.selectList(new EntityWrapper<JianzaocaiwuEntity>().in("jianzaocaiwu_uuid_number", seachFields.get("jianzaocaiwuUuidNumber")));
                        if(jianzaocaiwuEntities_jianzaocaiwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JianzaocaiwuEntity s:jianzaocaiwuEntities_jianzaocaiwuUuidNumber){
                                repeatFields.add(s.getJianzaocaiwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [监造财务编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jianzaocaiwuService.insertBatch(jianzaocaiwuList);
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

