
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
 * 经费预估
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jingfeiyugu")
public class JingfeiyuguController {
    private static final Logger logger = LoggerFactory.getLogger(JingfeiyuguController.class);

    private static final String TABLE_NAME = "jingfeiyugu";

    @Autowired
    private JingfeiyuguService jingfeiyuguService;


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
        PageUtils page = jingfeiyuguService.queryPage(params);

        //字典表数据转换
        List<JingfeiyuguView> list =(List<JingfeiyuguView>)page.getList();
        for(JingfeiyuguView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }

        params.put("limit","1000000");

        PageUtils page1 = jingfeiyuguService.queryPage(params);
        List<JingfeiyuguView> list1 =(List<JingfeiyuguView>)page1.getList();
        BigDecimal sumJine=new BigDecimal(0.0);
        for(JingfeiyuguView c:list1){
            sumJine=sumJine.add(new BigDecimal(c.getJingfeiyuguZongjia()));
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
        JingfeiyuguEntity jingfeiyugu = jingfeiyuguService.selectById(id);
        if(jingfeiyugu !=null){
            //entity转view
            JingfeiyuguView view = new JingfeiyuguView();
            BeanUtils.copyProperties( jingfeiyugu , view );//把实体数据重构到view中
            //级联表 项目
            //级联表
            XiangmuEntity xiangmu = xiangmuService.selectById(jingfeiyugu.getXiangmuId());
            if(xiangmu != null){
            BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXiangmuId(xiangmu.getId());
            }
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(jingfeiyugu.getYuangongId());
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
    public R save(@RequestBody JingfeiyuguEntity jingfeiyugu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jingfeiyugu:{}",this.getClass().getName(),jingfeiyugu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            jingfeiyugu.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JingfeiyuguEntity> queryWrapper = new EntityWrapper<JingfeiyuguEntity>()
            .eq("xiangmu_id", jingfeiyugu.getXiangmuId())
            .eq("yuangong_id", jingfeiyugu.getYuangongId())
            .eq("jingfeiyugu_name", jingfeiyugu.getJingfeiyuguName())
            .eq("jingfeiyugu_danwei", jingfeiyugu.getJingfeiyuguDanwei())
            .eq("cailiao_types", jingfeiyugu.getCailiaoTypes())
            .eq("jingfeiyugu_number", jingfeiyugu.getJingfeiyuguNumber())
            .eq("jingfeiyugu_gongsi", jingfeiyugu.getJingfeiyuguGongsi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingfeiyuguEntity jingfeiyuguEntity = jingfeiyuguService.selectOne(queryWrapper);
        if(jingfeiyuguEntity==null){

            jingfeiyugu.setJingfeiyuguZongjia(jingfeiyugu.getJingfeiyuguDanjia()*jingfeiyugu.getJingfeiyuguNumber());
            jingfeiyugu.setInsertTime(new Date());
            jingfeiyugu.setCreateTime(new Date());
            jingfeiyuguService.insert(jingfeiyugu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JingfeiyuguEntity jingfeiyugu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jingfeiyugu:{}",this.getClass().getName(),jingfeiyugu.toString());
        JingfeiyuguEntity oldJingfeiyuguEntity = jingfeiyuguService.selectById(jingfeiyugu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            jingfeiyugu.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jingfeiyugu.getJingfeiyuguFile()) || "null".equals(jingfeiyugu.getJingfeiyuguFile())){
                jingfeiyugu.setJingfeiyuguFile(null);
        }
        if("".equals(jingfeiyugu.getJingfeiyuguContent()) || "null".equals(jingfeiyugu.getJingfeiyuguContent())){
                jingfeiyugu.setJingfeiyuguContent(null);
        }
        jingfeiyugu.setJingfeiyuguZongjia(jingfeiyugu.getJingfeiyuguDanjia()*jingfeiyugu.getJingfeiyuguNumber());

            jingfeiyuguService.updateById(jingfeiyugu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JingfeiyuguEntity> oldJingfeiyuguList =jingfeiyuguService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jingfeiyuguService.deleteBatchIds(Arrays.asList(ids));

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
            List<JingfeiyuguEntity> jingfeiyuguList = new ArrayList<>();//上传的东西
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
                            JingfeiyuguEntity jingfeiyuguEntity = new JingfeiyuguEntity();
//                            jingfeiyuguEntity.setXiangmuId(Integer.valueOf(data.get(0)));   //项目 要改的
//                            jingfeiyuguEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            jingfeiyuguEntity.setJingfeiyuguUuidNumber(data.get(0));                    //经费预估编号 要改的
//                            jingfeiyuguEntity.setJingfeiyuguName(data.get(0));                    //材料名称 要改的
//                            jingfeiyuguEntity.setJingfeiyuguDanwei(data.get(0));                    //单价单位 要改的
//                            jingfeiyuguEntity.setJingfeiyuguDanjia(data.get(0));                    //材料单价 要改的
//                            jingfeiyuguEntity.setCailiaoTypes(Integer.valueOf(data.get(0)));   //材料类型 要改的
//                            jingfeiyuguEntity.setJingfeiyuguNumber(Integer.valueOf(data.get(0)));   //所需数量 要改的
//                            jingfeiyuguEntity.setJingfeiyuguZongjia(data.get(0));                    //预计总价 要改的
//                            jingfeiyuguEntity.setJingfeiyuguGongsi(data.get(0));                    //推荐公司 要改的
//                            jingfeiyuguEntity.setJingfeiyuguFile(data.get(0));                    //执行标准 要改的
//                            jingfeiyuguEntity.setJingfeiyuguContent("");//详情和图片
//                            jingfeiyuguEntity.setInsertTime(date);//时间
//                            jingfeiyuguEntity.setCreateTime(date);//时间
                            jingfeiyuguList.add(jingfeiyuguEntity);


                            //把要查询是否重复的字段放入map中
                                //经费预估编号
                                if(seachFields.containsKey("jingfeiyuguUuidNumber")){
                                    List<String> jingfeiyuguUuidNumber = seachFields.get("jingfeiyuguUuidNumber");
                                    jingfeiyuguUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jingfeiyuguUuidNumber = new ArrayList<>();
                                    jingfeiyuguUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jingfeiyuguUuidNumber",jingfeiyuguUuidNumber);
                                }
                        }

                        //查询是否重复
                         //经费预估编号
                        List<JingfeiyuguEntity> jingfeiyuguEntities_jingfeiyuguUuidNumber = jingfeiyuguService.selectList(new EntityWrapper<JingfeiyuguEntity>().in("jingfeiyugu_uuid_number", seachFields.get("jingfeiyuguUuidNumber")));
                        if(jingfeiyuguEntities_jingfeiyuguUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JingfeiyuguEntity s:jingfeiyuguEntities_jingfeiyuguUuidNumber){
                                repeatFields.add(s.getJingfeiyuguUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [经费预估编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jingfeiyuguService.insertBatch(jingfeiyuguList);
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

