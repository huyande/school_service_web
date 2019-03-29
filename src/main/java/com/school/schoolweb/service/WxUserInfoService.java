package com.school.schoolweb.service;

import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.CountInfo;
import com.school.schoolweb.bean.Wxuserinfo;
import com.school.schoolweb.bean.otherbean.SexCount;

import java.util.List;

public interface WxUserInfoService {

	Wxuserinfo findByOpenId(String openid);

	int addWxUserInfo(Wxuserinfo wxuserinfo);

	PageInfo<Wxuserinfo> findAllWxUser(Integer currentpage, Integer pagesize,String search);

	int getUserCount();

	CountInfo getUserDayCount();

	List<SexCount> sexcount();
}
