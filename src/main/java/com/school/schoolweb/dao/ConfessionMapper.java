package com.school.schoolweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.school.schoolweb.bean.Confession;
import com.school.schoolweb.bean.SchoolImage;

public interface ConfessionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Confession record);

    int insertSelective(Confession record);

    Confession selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Confession record);

    int updateByPrimaryKey(Confession record);

	List<Confession> findAllConfess();

	int countItem();

}