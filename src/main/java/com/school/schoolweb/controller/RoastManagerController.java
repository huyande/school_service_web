package com.school.schoolweb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	
	
	
	
	
}
