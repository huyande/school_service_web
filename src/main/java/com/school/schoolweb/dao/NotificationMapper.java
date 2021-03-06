package com.school.schoolweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.school.schoolweb.bean.Notification;

public interface NotificationMapper {
    int insert(Notification record);

	List<Notification> findnotificationDataList(@Param(value = "pageStart") int pageStart, @Param(value = "pageSize") int pageSize, @Param(value = "toopenid") String toopenid);
}