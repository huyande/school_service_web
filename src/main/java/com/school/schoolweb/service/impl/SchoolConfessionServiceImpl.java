package com.school.schoolweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.Wxuserinfo;
import com.school.schoolweb.bean.ana.ScConfessionJson;
import com.school.schoolweb.bean.ana.User;
import com.school.schoolweb.bean.otherbean.IncognitoCount;
import com.school.schoolweb.bean.otherbean.SexCount;
import com.school.schoolweb.dao.LikedMapper;
import com.school.schoolweb.dao.WxuserinfoMapper;
import com.school.schoolweb.utils.DateUtil;
import com.school.schoolweb.utils.JacksonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.school.schoolweb.bean.Confession;
import com.school.schoolweb.bean.CountInfo;
import com.school.schoolweb.bean.SchoolImage;
import com.school.schoolweb.dao.ConfessionMapper;
import com.school.schoolweb.dao.CountInfoMapper;
import com.school.schoolweb.service.SchoolConfessionService;

@Service
public class SchoolConfessionServiceImpl implements SchoolConfessionService{

	@Autowired
	private ConfessionMapper confessionMapper;

	@Autowired
	private WxuserinfoMapper wxuserinfoMapper;

	@Autowired
	private LikedMapper likedMapper;
	
	@Autowired
	private CountInfoMapper countInfoMapper;

	//图片地址前缀
	@Value("${qiniu.imageAddress}")
	private String imageAddress;

	@Override
	public Confession findConfessionByConfid(String confid) {
		return confessionMapper.selectByPrimaryKey(confid);
	}

	@Override
	public int deleteConfessionById(String confid) {
		return confessionMapper.deleteByPrimaryKey(confid);
	}

	@Override
	public PageInfo<ScConfessionJson> findAllConfess(Integer currentpage, Integer pagesize,String search) {
		int page = currentpage==null?1:currentpage;
		int pageSize = pagesize==null?10:pagesize;
		PageHelper.startPage(page,pageSize);
		List<Confession> confessionList = confessionMapper.findAllConfess(search);
		List<ScConfessionJson> scConfessionJsons = new ArrayList<>();
		for (Confession conf:confessionList) {
			ScConfessionJson scConfessionJson = new ScConfessionJson();
			Wxuserinfo wxuserinfo = wxuserinfoMapper.findByOpenId(conf.getOpenid());

			User user = new User();
			user.setAvatar(wxuserinfo.getAvatarurl());
			user.setSex(wxuserinfo.getGender());
			user.setTouser(conf.getTouser());
			user.setFromuser(wxuserinfo.getNickname());
			//发布信息用户的id
			user.setUserId(wxuserinfo.getOpenid());
			//设置用户
			scConfessionJson.setUser(user);

			scConfessionJson.setId(conf.getId());
			scConfessionJson.setContent(conf.getContent());
			//是否是匿名
			scConfessionJson.setStateNiming(conf.getStateniming());
			//点赞的数量
			scConfessionJson.setLikedCount(likedMapper.likedCount(conf.getId()));
			//设置时间
			//scConfessionJson.setTime(Integer.parseInt(DataTimeUtils.date2TimeStamp(conf.getTime().toString(), "yyyy-MM-dd HH:mm:ss")));
			scConfessionJson.setTime(DateUtil.format(DateUtil.convertStrToDate(conf.getTime()),"yyyy/MM/dd"));
			//遍历图片数组
			scConfessionJson.setImage(imageAddress+conf.getImage());
			scConfessionJsons.add(scConfessionJson);
		}
		int count = confessionMapper.countItemSearch(search);
		PageInfo<ScConfessionJson> pageInfo = new PageInfo<>();
		pageInfo.setList(scConfessionJsons);
		pageInfo.setTotal(count);
		return pageInfo;
	}

	@Override
	public String statisticalConfCountAndNewCount() {
		int countItem = confessionMapper.countItem();
		//2 代表 conf 那列 
		CountInfo countInfo = countInfoMapper.findbyId(2);
		int increaseCount=countItem-countInfo.getCount();
		JSONObject jsonObject = new JSONObject();
		Map<String,Integer> map = new HashMap<>();
		map.put("currentCount", countItem);
		map.put("increaseCount", increaseCount);
        jsonObject.put("data",map);
		return JacksonUtil.toJSon(jsonObject);
	}

	@Override
	public String statisticalConfCountSex() {
		 List<SexCount> sexCounts = confessionMapper.statisticalConfCountSex();
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

	@Override
	public String statisticalConfCountStateIncognito() {
		List<IncognitoCount> incognitoList = confessionMapper.statisticalConfCountStateIncognito();
		Map<String,Integer> map = new HashMap<>();
		for(IncognitoCount inc :incognitoList){
			if(inc.getIncognito()==0){//表示是匿名
				map.put("incognito", inc.getCount());
			}else{
				map.put("realName", inc.getCount());
			}
		}
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",map);
        return JacksonUtil.toJSon(jsonObject);
	}

	@Override
	public List<ScConfessionJson> findConfessionsOrderByItem(int itemCount) {
		List<Confession> confessionList = confessionMapper.findConfessionsOrderByItem(itemCount);
		List<ScConfessionJson> scConfessionJsons = new ArrayList<>();
		for (Confession conf:confessionList) {
			ScConfessionJson scConfessionJson = new ScConfessionJson();
			Wxuserinfo wxuserinfo = wxuserinfoMapper.findByOpenId(conf.getOpenid());

			User user = new User();
			user.setAvatar(wxuserinfo.getAvatarurl());
			user.setSex(wxuserinfo.getGender());
			user.setTouser(conf.getTouser());
			user.setFromuser(wxuserinfo.getNickname());
			//发布信息用户的id
			user.setUserId(wxuserinfo.getOpenid());
			//设置用户
			scConfessionJson.setUser(user);

			scConfessionJson.setId(conf.getId());
			scConfessionJson.setContent(conf.getContent());
			//是否是匿名
			scConfessionJson.setStateNiming(conf.getStateniming());
			//点赞的数量
			scConfessionJson.setLikedCount(likedMapper.likedCount(conf.getId()));
			//设置时间
			//scConfessionJson.setTime(Integer.parseInt(DataTimeUtils.date2TimeStamp(conf.getTime().toString(), "yyyy-MM-dd HH:mm:ss")));
			scConfessionJson.setTime(DateUtil.format(DateUtil.convertStrToDate(conf.getTime()),"yyyy/MM/dd"));
			//遍历图片数组
			scConfessionJson.setImage(imageAddress+conf.getImage());
			scConfessionJson.setNumCount(conf.getNumCount());
			scConfessionJsons.add(scConfessionJson);
		}
		
		
		
		return scConfessionJsons;
	}

	@Override
	public String changeConfessionStatus(String confid,int stutas) {
		int num = confessionMapper.changeConfessionStatus(confid,stutas);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("result", num==0?false:true);
		return JacksonUtil.toJSon(jsonObj);
	}

}
