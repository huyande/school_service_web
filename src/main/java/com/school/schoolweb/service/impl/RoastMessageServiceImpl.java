package com.school.schoolweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolweb.bean.MessageRoast;
import com.school.schoolweb.dao.MessageRoastMapper;
import com.school.schoolweb.service.RoastMessageService;

@Service
public class RoastMessageServiceImpl implements RoastMessageService {

	@Autowired
	private MessageRoastMapper messageRoastMapper;
	
	@Override
	public List<MessageRoast> findRoastMessages(Integer roastId, Integer page, Integer pagesize) {
		return messageRoastMapper.findByRoastIdMessages(roastId,(page-1)*pagesize,pagesize);
	}

	@Override
	public int countByRoastId(Integer roastId) {
		return messageRoastMapper.countByRoastId(roastId);
	}

	@Override
	public int addMessage(MessageRoast messageRoast) {
		return messageRoastMapper.insert(messageRoast);
	}

}
