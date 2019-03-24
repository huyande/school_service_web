package com.school.schoolweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.schoolweb.bean.Confession;
import com.school.schoolweb.bean.ana.RoastJSON;
import com.school.schoolweb.bean.ana.ScConfessionJson;
import com.school.schoolweb.service.RoastMessageService;
import com.school.schoolweb.service.RoastService;
import com.school.schoolweb.service.SchoolConfessionService;

@Controller()
@RequestMapping("admin")
public class IndexManagerController {
	
	@Autowired
	private SchoolConfessionService schoolConfessionService;
	
	@Autowired
	private RoastService roastService;

	@RequestMapping("index")
	public String indexView(Model model){
		//查询表白信息点赞数高的前十条  
		int itemCount=10;
		List<ScConfessionJson> confList = schoolConfessionService.findConfessionsOrderByItem(itemCount);
		List<RoastJSON> roastList = roastService.findConfessionsOrderByItem(itemCount);
		model.addAttribute("confList", confList);
		model.addAttribute("roastList", roastList);
		return "admin/index";
	}
}
