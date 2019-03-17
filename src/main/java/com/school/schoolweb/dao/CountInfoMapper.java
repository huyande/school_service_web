package com.school.schoolweb.dao;

import org.apache.ibatis.annotations.Param;

import com.school.schoolweb.bean.CountInfo;

public interface CountInfoMapper {
	
    CountInfo findbyId(int id);
    
    void updataCountInfo(@Param(value="count") Integer count,@Param(value="type") String type);
}
