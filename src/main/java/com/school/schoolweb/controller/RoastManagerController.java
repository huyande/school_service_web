package com.school.schoolweb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.ana.ScRoastJson;
import com.school.schoolweb.service.RoastService;
import com.school.schoolweb.utils.JacksonUtil;

/**
 * 吐槽墙
 * @author Administrator
 *
 */
@Controller
@RequestMapping("admin/roast") 
public class RoastManagerController {
	
	Logger LOG = LoggerFactory.getLogger(RoastManagerController.class);
	
	
	@Autowired
	private RoastService roastService;
	
	/**
	 * 跳转到吐槽信息页面
	 * @return
	 */
	@GetMapping("/roastManager")
	public String roastManager(Model model) {
		roastService.roastNewAndIncCount(model);
		return "/admin/roastManager";
	}
	
	//获取吐槽总数和新增数	
	@GetMapping("roastCountInfo")
	@ResponseBody
	public String roastCountInfo(){
		LOG.info("获取吐槽总数和新增数");
		return roastService.roastCountInfo();
	}
	
	/**
	 * 获取吐槽信息列表
	 * @return
	 */
	@GetMapping("roastlist")
	@ResponseBody
	public String roastlist(Integer currentpage,Integer pagesize,String search){
		LOG.info("获取吐槽信息列表");
		PageInfo<ScRoastJson> pageInfo =roastService.findAllRoastList(currentpage,pagesize,search);
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",pageInfo.getTotal());
        jsonObject.put("data",pageInfo.getList());
        return JacksonUtil.toJSon(jsonObject);
	}
	
	/**
	 * 统计吐槽信息性别比例
	 */
	@GetMapping("roastCountSex")
	@ResponseBody
	public String roastCountSex(){
		LOG.info("统计吐槽信息性别比例");
		return roastService.statisticalRoastCountSex();
	}
	
	/**
	 * 吐槽操作 -- 删除 --- 恢复
	 */
	@PostMapping("roastChanageStutas")
	@ResponseBody
	public String roastChanageStutas(int roastId,String funName){
		int stutas=0;
    	if(funName.equalsIgnoreCase("delete")){
    		return roastService.changeRoastStatus(roastId,stutas);
    	}else if(funName.equalsIgnoreCase("restore")){
    		stutas=1;
    		return roastService.changeRoastStatus(roastId,stutas);
    	}else{
    		return "{\"result\":\"error:Check the method\"}";
    	}
	}
	
	
	 /**
     * 统计分享数  暂定
     */
	
	
	
	
}
