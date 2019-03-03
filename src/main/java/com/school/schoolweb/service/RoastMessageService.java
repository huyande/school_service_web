package com.school.schoolweb.service;

import java.util.List;

import com.school.schoolweb.bean.MessageRoast;

/**
* @Description: 
* @author: hyd 
* @date: 2019年2月15日 下午2:29:19
 */
public interface RoastMessageService {

	List<MessageRoast> findRoastMessages(Integer roastId, Integer page, Integer pagesize);

	int countByRoastId(Integer roastId);

	int addMessage(MessageRoast messageRoast);

}
