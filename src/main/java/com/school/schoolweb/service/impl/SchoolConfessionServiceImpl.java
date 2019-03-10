package com.school.schoolweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.Wxuserinfo;
import com.school.schoolweb.bean.ana.ScConfessionJson;
import com.school.schoolweb.bean.ana.User;
import com.school.schoolweb.dao.LikedMapper;
import com.school.schoolweb.dao.WxuserinfoMapper;
import com.school.schoolweb.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.school.schoolweb.bean.Confession;
import com.school.schoolweb.bean.SchoolImage;
import com.school.schoolweb.dao.ConfessionMapper;
import com.school.schoolweb.service.SchoolConfessionService;

@Service
public class SchoolConfessionServiceImpl implements SchoolConfessionService{

	@Autowired
	private ConfessionMapper confessionMapper;

	@Autowired
	private WxuserinfoMapper wxuserinfoMapper;

	@Autowired
	private LikedMapper likedMapper;

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
	public PageInfo<ScConfessionJson> findAllConfess(Integer currentpage, Integer pagesize) {
		int page = currentpage==null?1:currentpage;
		int pageSize = pagesize==null?10:pagesize;
		PageHelper.startPage(page,pageSize);
		List<Confession> confessionList = confessionMapper.findAllConfess();
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
		int count = confessionMapper.countItem();
		PageInfo<ScConfessionJson> pageInfo = new PageInfo<>();
		pageInfo.setList(scConfessionJsons);
		pageInfo.setTotal(count);
		return pageInfo;
	}

}
