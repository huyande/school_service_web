package com.school.schoolweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.CountInfo;
import com.school.schoolweb.bean.Wxuserinfo;
import com.school.schoolweb.bean.otherbean.SexCount;
import com.school.schoolweb.service.WxUserInfoService;
import com.school.schoolweb.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin/user")
public class UserManagerController {

    @Autowired
    private WxUserInfoService wxUserInfoService;

    /**
     * 获取用户列表
     * @param currentpage
     * @param pagesize
     * @return
     */
    @GetMapping("userlist")
    public String userlist(Integer currentpage,Integer pagesize){
        //PageInfo<Wxuserinfo> pageInfo = new PageInfo<>();
        PageInfo<Wxuserinfo> pageInfo = wxUserInfoService.findAllWxUser(currentpage,pagesize);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",pageInfo.getTotal());
        jsonObject.put("data",pageInfo.getList());
        return JacksonUtil.toJSon(jsonObject);
    }

    /**
     * 查看用户详情
     */
    @GetMapping("userinfo")
    public String userinfo(String openid){
        Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(openid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",wxuserinfo);
        return JacksonUtil.toJSon(jsonObject);
    }

    /**
     * 获取用户总数 用户日增量
     */
    @GetMapping("usercont")
    public String usercont(){
        int  count = wxUserInfoService.getUserCount();
        CountInfo dayCount = wxUserInfoService.getUserDayCount();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("currentCount",count);
        jsonObject.put("increaseCount",count-dayCount.getCount());
        return JacksonUtil.toJSon(jsonObject);
    }

    @GetMapping("sexcount")
    public String sexcount(){
        List<SexCount> sexCounts = wxUserInfoService.sexcount();
        Map<String,Integer> map = new HashMap<>();
        for(SexCount sex:sexCounts){
            if(sex.getSextype()==0){
                map.put("UNKnow",sex.getSexcount());
            }else if(sex.getSextype()==1){
                map.put("man",sex.getSexcount());
            }else{
                map.put("woman",sex.getSexcount());
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",map);
        return JacksonUtil.toJSon(jsonObject);
    }

}
