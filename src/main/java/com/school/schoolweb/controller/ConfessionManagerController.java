package com.school.schoolweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.Confession;
import com.school.schoolweb.bean.ana.ScConfessionJson;
import com.school.schoolweb.service.SchoolConfessionService;
import com.school.schoolweb.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("confession")
public class ConfessionManagerController {

    @Autowired
    private SchoolConfessionService schoolConfessionService;


    @GetMapping("conflist")
    public String conflist(Integer currentpage,Integer pagesize){
        PageInfo<ScConfessionJson> pageInfo = schoolConfessionService.findAllConfess(currentpage,pagesize);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",pageInfo.getTotal());
        jsonObject.put("data",pageInfo.getList());
        return JacksonUtil.toJSon(jsonObject);
    }
    
    /**
     * 表白信息统计  获取到总数 和新增数  
     */
    @GetMapping("confCountinfo")
    public String confCountinfo(){
    	String info = schoolConfessionService.statisticalConfCountAndNewCount();
    	return info;
    }
    
    /**
     * 统计表白信息性别数  
     */
    @GetMapping("confCountSex")
    public String confCountSex(){
    	String info = schoolConfessionService.statisticalConfCountSex();
    	return info;
    }
    
    /**
     * 统计表白信息匿名实名情况
     */
    @GetMapping("confCountStateIncognito")
    public String confCountStateIncognito(){
    	String info = schoolConfessionService.statisticalConfCountStateIncognito();
    	return info;
    }
    
    
    
    
    /**
     * 统计分享数  暂定
     */
}
