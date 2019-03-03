package com.school.schoolweb.service;

import java.util.List;

import com.school.schoolweb.bean.Notification;

public interface NotificationService {

	int addNotificationMessage(Notification notification);

	List<Notification> findnotificationDataList(Integer page, Integer pageSize, String openid);

}
