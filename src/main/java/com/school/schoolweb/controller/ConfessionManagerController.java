package com.school.schoolweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.ana.ScConfessionJson;
import com.school.schoolweb.service.SchoolConfessionService;
import com.school.schoolweb.utils.JacksonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/confession")
public class ConfessionManagerController {
	
	Logger LOG = LoggerFactory.getLogger(ConfessionManagerController.class);

    @Autowired
    private SchoolConfessionService schoolConfessionService;


    @GetMapping("conflist")
    public String conflist(Integer currentpage,Integer pagesize,String search){
    	LOG.info("执行表白列表查询");
        PageInfo<ScConfessionJson> pageInfo = schoolConfessionService.findAllConfess(currentpage,pagesize,search);
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
    	LOG.info("表白信息统计");
    	String info = schoolConfessionService.statisticalConfCountAndNewCount();
    	return info;
    }
    
    /**
     * 统计表白信息性别数  
     */
    @GetMapping("confCountSex")
    public String confCountSex(){
    	LOG.info("表白性别统计");
    	String info = schoolConfessionService.statisticalConfCountSex();
    	return info;
    }
    
    /**
     * 统计表白信息匿名实名情况
     */
    @GetMapping("confCountStateIncognito")
    public String confCountStateIncognito(){
    	LOG.info("表白信息匿实统计");
    	String info = schoolConfessionService.statisticalConfCountStateIncognito();
    	return info;
    }
    
    /**
     * 统计分享数  暂定
     */
    
    
    
    /**
     * 表白操作 --- 删除 表白 delete  ---恢复表白 restore
     */
    @GetMapping("confChanageStutas")
    public String confDelete(String confid,String funName){
    	int stutas=0;
    	if(funName.equalsIgnoreCase("delete")){
    		return schoolConfessionService.changeConfessionStatus(confid,stutas);
    	}else if(funName.equalsIgnoreCase("restore")){
    		stutas=1;
    		return schoolConfessionService.changeConfessionStatus(confid,stutas);
    	}else{
    		return "{\"result\":\"error:Check the method\"}";
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
