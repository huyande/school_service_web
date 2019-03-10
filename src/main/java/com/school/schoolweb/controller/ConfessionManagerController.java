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
}
