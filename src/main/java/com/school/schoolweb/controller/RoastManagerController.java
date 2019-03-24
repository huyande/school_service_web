package com.school.schoolweb.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.schoolweb.service.RoastMessageService;
import com.school.schoolweb.service.RoastService;

/**
 * 吐槽墙
 * @author Administrator
 *
 */
@Controller
@RequestMapping("admin/roast")
public class RoastManagerController {
	
	@Autowired
	private RoastService roastService;

	//获取吐槽总数和新增数	
	@GetMapping("roastCountInfo")
	@ResponseBody
	public String roastCountInfo(){
		return roastService.roastCountInfo();
	}
}
