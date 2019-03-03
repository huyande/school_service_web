package com.school.schoolweb.service;

import java.util.List;

import com.school.schoolweb.bean.MessageConf;

public interface MessageConfService {

	List<MessageConf> getconfMessageList(String confid, Integer page, Integer pageSize);

	int countItem(String confid);

	int insertMessage(String confid, String openid, String message);

}
