package com.school.schoolweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.school.schoolweb.bean.Roast;

public interface RoastMapper {
    int insert(Roast record);

    int insertSelective(Roast record);

	List<Roast> findRoaseDatas(@Param(value = "pageStart") int pageStart, @Param(value = "pageSize") int pageSize);

	int deleteByRoastId(@Param(value = "roastid") Integer roastid);

	List<Roast> findRoaseMyDatas(String openid, @Param(value = "pageStart") int pageStart, @Param(value = "pageSize") int pageSize);

	Roast findroastByRoastId(@Param(value = "roastid") int roastid);

	int countItem();

	List<Roast> findConfessionsOrderByItem(int itemCount);
}