package com.school.schoolweb.dao;

import com.school.schoolweb.bean.Wxuserinfo;
import com.school.schoolweb.bean.otherbean.SexCount;

import java.util.List;

public interface WxuserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wxuserinfo record);

    int insertSelective(Wxuserinfo record);

    Wxuserinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wxuserinfo record);

    int updateByPrimaryKey(Wxuserinfo record);

	Wxuserinfo findByOpenId(String openid);

	List<Wxuserinfo> findAllWxUser();

	int getUserCount();

    List<SexCount> sexcount();
}