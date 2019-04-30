package com.school.schoolweb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.school.schoolweb.service.RoastService;

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
	public String roastlist(){
		LOG.info("获取吐槽信息列表");
		String data = roastService.findAllRoast();
		return data;
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
