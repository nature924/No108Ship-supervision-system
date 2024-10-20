
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
 * 材料参考
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cailiaocankao")
public class CailiaocankaoController {
    private static final Logger logger = LoggerFactory.getLogger(CailiaocankaoController.class);

    private static final String TABLE_NAME = "cailiaocankao";

    @Autowired
    private CailiaocankaoService cailiaocankaoService;


    @Autowired
    private TokenService tokenService;

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
        PageUtils page = cailiaocankaoService.queryPage(params);

        //字典表数据转换
        List<CailiaocankaoView> list =(List<CailiaocankaoView>)page.getList();
        for(CailiaocankaoView c:list){
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
        CailiaocankaoEntity cailiaocankao = cailiaocankaoService.selectById(id);
        if(cailiaocankao !=null){
            //entity转view
            CailiaocankaoView view = new CailiaocankaoView();
            BeanUtils.copyProperties( cailiaocankao , view );//把实体数据重构到view中
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
    public R save(@RequestBody CailiaocankaoEntity cailiaocankao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cailiaocankao:{}",this.getClass().getName(),cailiaocankao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<CailiaocankaoEntity> queryWrapper = new EntityWrapper<CailiaocankaoEntity>()
            .eq("cailiaocankao_name", cailiaocankao.getCailiaocankaoName())
            .eq("cailiao_types", cailiaocankao.getCailiaoTypes())
            .eq("cailiaocankao_danwei", cailiaocankao.getCailiaocankaoDanwei())
            .eq("cailiaocankao_guige", cailiaocankao.getCailiaocankaoGuige())
            .eq("cailiaocankao_gongsi", cailiaocankao.getCailiaocankaoGongsi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CailiaocankaoEntity cailiaocankaoEntity = cailiaocankaoService.selectOne(queryWrapper);
        if(cailiaocankaoEntity==null){
            cailiaocankao.setInsertTime(new Date());
            cailiaocankao.setCreateTime(new Date());
            cailiaocankaoService.insert(cailiaocankao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CailiaocankaoEntity cailiaocankao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,cailiaocankao:{}",this.getClass().getName(),cailiaocankao.toString());
        CailiaocankaoEntity oldCailiaocankaoEntity = cailiaocankaoService.selectById(cailiaocankao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(cailiaocankao.getCailiaocankaoFile()) || "null".equals(cailiaocankao.getCailiaocankaoFile())){
                cailiaocankao.setCailiaocankaoFile(null);
        }
        if("".equals(cailiaocankao.getCailiaocankaoContent()) || "null".equals(cailiaocankao.getCailiaocankaoContent())){
                cailiaocankao.setCailiaocankaoContent(null);
        }

            cailiaocankaoService.updateById(cailiaocankao);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<CailiaocankaoEntity> oldCailiaocankaoList =cailiaocankaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        cailiaocankaoService.deleteBatchIds(Arrays.asList(ids));

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
            List<CailiaocankaoEntity> cailiaocankaoList = new ArrayList<>();//上传的东西
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
                            CailiaocankaoEntity cailiaocankaoEntity = new CailiaocankaoEntity();
//                            cailiaocankaoEntity.setCailiaocankaoUuidNumber(data.get(0));                    //材料编号 要改的
//                            cailiaocankaoEntity.setCailiaocankaoName(data.get(0));                    //材料名称 要改的
//                            cailiaocankaoEntity.setCailiaoTypes(Integer.valueOf(data.get(0)));   //材料类型 要改的
//                            cailiaocankaoEntity.setCailiaocankaoDanwei(data.get(0));                    //单价单位 要改的
//                            cailiaocankaoEntity.setCailiaocankaoDanjia(data.get(0));                    //参考单价 要改的
//                            cailiaocankaoEntity.setCailiaocankaoGuige(data.get(0));                    //材料规格 要改的
//                            cailiaocankaoEntity.setCailiaocankaoFile(data.get(0));                    //执行标准 要改的
//                            cailiaocankaoEntity.setCailiaocankaoGongsi(data.get(0));                    //推荐公司 要改的
//                            cailiaocankaoEntity.setCailiaocankaoContent("");//详情和图片
//                            cailiaocankaoEntity.setInsertTime(date);//时间
//                            cailiaocankaoEntity.setCreateTime(date);//时间
                            cailiaocankaoList.add(cailiaocankaoEntity);


                            //把要查询是否重复的字段放入map中
                                //材料编号
                                if(seachFields.containsKey("cailiaocankaoUuidNumber")){
                                    List<String> cailiaocankaoUuidNumber = seachFields.get("cailiaocankaoUuidNumber");
                                    cailiaocankaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cailiaocankaoUuidNumber = new ArrayList<>();
                                    cailiaocankaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("cailiaocankaoUuidNumber",cailiaocankaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //材料编号
                        List<CailiaocankaoEntity> cailiaocankaoEntities_cailiaocankaoUuidNumber = cailiaocankaoService.selectList(new EntityWrapper<CailiaocankaoEntity>().in("cailiaocankao_uuid_number", seachFields.get("cailiaocankaoUuidNumber")));
                        if(cailiaocankaoEntities_cailiaocankaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CailiaocankaoEntity s:cailiaocankaoEntities_cailiaocankaoUuidNumber){
                                repeatFields.add(s.getCailiaocankaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [材料编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cailiaocankaoService.insertBatch(cailiaocankaoList);
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

