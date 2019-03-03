package com.school.schoolweb.service;

import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.UserCount;
import com.school.schoolweb.bean.Wxuserinfo;
import com.school.schoolweb.bean.otherbean.SexCount;

import java.util.List;

public interface WxUserInfoService {

	Wxuserinfo findByOpenId(String openid);

	int addWxUserInfo(Wxuserinfo wxuserinfo);

	PageInfo<Wxuserinfo> findAllWxUser(Integer currentpage, Integer pagesize);

	int getUserCount();

	UserCount getUserDayCount();

	List<SexCount> sexcount();
}
