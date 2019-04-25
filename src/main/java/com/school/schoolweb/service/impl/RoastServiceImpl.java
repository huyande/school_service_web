package com.school.schoolweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.CountInfo;
import com.school.schoolweb.bean.Roast;
import com.school.schoolweb.bean.Wxuserinfo;
import com.school.schoolweb.bean.ana.RoastJSON;
import com.school.schoolweb.bean.ana.ScRoastJson;
import com.school.schoolweb.bean.ana.User;
import com.school.schoolweb.dao.CountInfoMapper;
import com.school.schoolweb.dao.LikeRoastMapper;
import com.school.schoolweb.dao.MessageRoastMapper;
import com.school.schoolweb.dao.RoastMapper;
import com.school.schoolweb.dao.WxuserinfoMapper;
import com.school.schoolweb.service.RoastService;
import com.school.schoolweb.utils.DateUtil;
import com.school.schoolweb.utils.JacksonUtil;

@Service
public class RoastServiceImpl implements RoastService {

	@Autowired
	private RoastMapper roastMapper;
	
	@Autowired
	private CountInfoMapper countInfoMapper;
	
	@Autowired
	private LikeRoastMapper likeRoastMapper;
	
	@Autowired
	private MessageRoastMapper messageRoastMapper;
	
	@Autowired
	private WxuserinfoMapper wxuserinfoMapper;

	//分页查找所有状态为1 的吐槽数据  废除
	@Override
	public List<Roast> findRoaseDatas(Integer page, Integer pagesize) {
		return roastMapper.findRoaseDatas((page-1)*pagesize,pagesize);
	}

	//废除
	@Override
	public int addRoast(Roast roast) {
		return roastMapper.insert(roast);
	}

	//暂留
	@Override
	public int deleteByRoastId(Integer roastid) {
		return roastMapper.deleteByRoastId(roastid);
	}

	//废除
	@Override
	public List<Roast> findRoaseMyDatas(String openid, Integer page, Integer pagesize) {
		return roastMapper.findRoaseMyDatas(openid,(page-1)*pagesize,pagesize);
	}

	//废除
	@Override
	public Roast findroastByRoastId(int roastid) {
		return roastMapper.findroastByRoastId(roastid);
	}

	
	
	
	@Override
	public String roastCountInfo() {
		int countItem = roastMapper.countItem();
		//2 代表 conf 那列 
		CountInfo countInfo = countInfoMapper.findbyId(3);
		int increaseCount=countItem-countInfo.getCount();
		JSONObject jsonObject = new JSONObject();
		Map<String,Integer> map = new HashMap<>();
		map.put("currentCount", countItem);
		map.put("increaseCount", increaseCount);
        jsonObject.put("data",map);
		return JacksonUtil.toJSon(jsonObject);
	}

	
	@Override
	public List<RoastJSON> findConfessionsOrderByItem(int itemCount) {
		//创建一个返回吐槽列表的集合 
		List<RoastJSON> roaseDatas = new ArrayList<>();
		List<Roast> roases = roastMapper.findConfessionsOrderByItem(itemCount);
		for (Roast roast : roases) {
			
			Wxuserinfo wxuserinfo = wxuserinfoMapper.findByOpenId(roast.getOpenid());

			User user = new User();
			user.setAvatar(wxuserinfo.getAvatarurl());
			user.setSex(wxuserinfo.getGender());
			user.setFromuser(wxuserinfo.getNickname());
			//发布信息用户的id
			user.setUserId(wxuserinfo.getOpenid());
			
			RoastJSON roastJSON = new RoastJSON();
			
			roastJSON.setUser(user);
			roastJSON.setNumCount(roast.getNumCount());
			
			roastJSON.setId(roast.getId());
			roastJSON.setContent(roast.getContent());
			roastJSON.setBackgroupcolor(roast.getBackgroupcolor());
			//查询点赞数量
			int roastCount = likeRoastMapper.roastLikeCount(roast.getId());
			int messageCount = messageRoastMapper.countByRoastId(roast.getId());
			roastJSON.setLikeCount(roastCount);
			roastJSON.setMessageCount(messageCount);
			roastJSON.setCreatetime(DateUtil.format(DateUtil.convertStrToDate(roast.getCreatetime()),"yyyy/MM/dd"));
			roaseDatas.add(roastJSON);
		}
		return roaseDatas;
	}

	
	/**
	 * 分页查询吐槽信息 
	 */
	@Override
	public String findAllRoast() {
		List<Roast> roastlist = roastMapper.findAllRoast();
		//创建一个返回吐槽对象的json 集合
		List<ScRoastJson> scRoastJson = new ArrayList<>();
		for (Roast roast : roastlist) {
			//查询吐槽用户
			Wxuserinfo wxuserinfo = wxuserinfoMapper.findByOpenId(roast.getOpenid());
			
			ScRoastJson roastJson = new ScRoastJson();
			//设置吐槽用户
			roastJson.setUser(wxuserinfo);
			//设置内容
			roastJson.setContent(roast.getContent());
			//设置发布时间
			roastJson.setCreatetime(roast.getCreatetime());
			//设置吐槽主键信息
			roastJson.setId(roast.getId());
			//设置吐槽状态
			roastJson.setState(roast.getState());
			scRoastJson.add(roastJson);
		}
		int total = roastMapper.countItem();
		//JSONObject jsonObject = new JSONObject();
		Map<String,Object> map = new HashMap<>();
		map.put("data", scRoastJson);
		map.put("total", total);
        //jsonObject.put("data",map);
		return JacksonUtil.toJSon(map);
	}
	
	
}
