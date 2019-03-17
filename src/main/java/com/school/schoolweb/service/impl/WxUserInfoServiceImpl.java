package com.school.schoolweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.CountInfo;
import com.school.schoolweb.bean.otherbean.SexCount;
import com.school.schoolweb.dao.CountInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolweb.bean.Wxuserinfo;
import com.school.schoolweb.dao.WxuserinfoMapper;
import com.school.schoolweb.service.WxUserInfoService;

import java.util.List;

@Service
public class WxUserInfoServiceImpl implements WxUserInfoService {

	@Autowired
	private WxuserinfoMapper wxuserinfoMapper;

	@Autowired
	private CountInfoMapper userCountMapper;

	@Override
	public Wxuserinfo findByOpenId(String openid) {
		Wxuserinfo wxuserinfo =wxuserinfoMapper.findByOpenId(openid);
		return wxuserinfo;
	}

	@Override
	public int addWxUserInfo(Wxuserinfo wxuserinfo) {
		return wxuserinfoMapper.insert(wxuserinfo);
	}

	/**
	 * 分页查询用户信息
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	@Override
	public PageInfo<Wxuserinfo> findAllWxUser(Integer currentpage, Integer pagesize) {
		int page = currentpage==null?1:currentpage;
		int pageSize = pagesize==null?10:pagesize;
		PageHelper.startPage(page,pageSize);
		List<Wxuserinfo> wxuserinfos = wxuserinfoMapper.findAllWxUser();
		int total  = wxuserinfoMapper.getUserCount();
		PageInfo<Wxuserinfo> pageInfo = new PageInfo<>();
		pageInfo.setList(wxuserinfos);
		pageInfo.setTotal(total);
		return pageInfo;
	}

	@Override
	public int getUserCount() {
		return wxuserinfoMapper.getUserCount();
	}

	@Override
	public CountInfo getUserDayCount() {
		//数据库中 第一列保存用户总数 
		return userCountMapper.findbyId(1);
	}

	@Override
	public List<SexCount> sexcount() {
		return wxuserinfoMapper.sexcount();
	}
}
