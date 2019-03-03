package com.school.schoolweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.school.schoolweb.bean.MessageRoast;

public interface MessageRoastMapper {
    int insert(MessageRoast record);

    int insertSelective(MessageRoast record);

	List<MessageRoast> findByRoastIdMessages(@Param(value = "roastId") Integer roastId, @Param(value = "pageStart") int pageStart, @Param(value = "pageSize") Integer pagesize);

	int countByRoastId(@Param(value = "roastId") Integer roastId);
}