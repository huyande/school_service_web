package com.school.schoolweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.CountInfo;
import com.school.schoolweb.bean.Wxuserinfo;
import com.school.schoolweb.bean.otherbean.SexCount;
import com.school.schoolweb.service.WxUserInfoService;
import com.school.schoolweb.utils.JacksonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/user")
public class UserManagerController {

	Logger log = LoggerFactory.getLogger(UserManagerController.class);
	
	
    @Autowired
    private WxUserInfoService wxUserInfoService;
    
    
    @GetMapping("userManager")
    public String userManager(Model model) {
    	 int  count = wxUserInfoService.getUserCount();
         CountInfo dayCount = wxUserInfoService.getUserDayCount();
         model.addAttribute("currentCount",count);
         model.addAttribute("increaseCount",count-dayCount.getCount());
         return "admin/usermanager";
    }
    
    
    /** 
     * 测试
    * @author hyd
    * @Description: 
    * @date 2019年4月11日 上午10:22:08
    * @return
     */
    
    @GetMapping("template")
    public String template() {
    	return "frameIndex";
    }
    
    @GetMapping("userm")
    public String userm() {
    	return "userm";
    }
    
    
    
    

    /**
     * 获取用户列表
     * @param currentpage
     * @param pagesize
     * @return
     */
    @GetMapping("userlist")
    @ResponseBody
    public String userlist(Integer currentpage,Integer pagesize,String search){
        //PageInfo<Wxuserinfo> pageInfo = new PageInfo<>();
    	log.info("获取用户列表");
    	PageInfo<Wxuserinfo> pageInfo = wxUserInfoService.findAllWxUser(currentpage,pagesize,search);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",pageInfo.getTotal());
        jsonObject.put("data",pageInfo.getList());
        return JacksonUtil.toJSon(jsonObject);
    }

    /**
     * 查看用户详情
     */
    @GetMapping("userinfo")
    @ResponseBody
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
    @ResponseBody
    public String usercont(){
        int  count = wxUserInfoService.getUserCount();
        CountInfo dayCount = wxUserInfoService.getUserDayCount();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("currentCount",count);
        jsonObject.put("increaseCount",count-dayCount.getCount());
        return JacksonUtil.toJSon(jsonObject);
    }

    @GetMapping("sexcount")
    @ResponseBody
    public String sexcount(){
    	log.info("性别数量比");
        List<SexCount> sexCounts = wxUserInfoService.sexcount();
        Map<String,Integer> map = new HashMap<>();
        //赋初始值
        map.put("UNKnow",0);
        map.put("man",0);
        map.put("woman",0);
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
