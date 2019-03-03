package com.school.schoolweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolweb.bean.MessageConf;
import com.school.schoolweb.dao.MessageConfMapper;
import com.school.schoolweb.service.MessageConfService;

@Service
public class MessageConfServiceImpl implements MessageConfService {

	@Autowired
	private MessageConfMapper messageConfMapper;
	
	@Override
	public List<MessageConf> getconfMessageList(String confid,Integer page,Integer pageSize) {
		return messageConfMapper.getconfMessageList(confid,(page-1)*pageSize,pageSize);
	}

	@Override
	public int countItem(String confid) {
		return messageConfMapper.countItem(confid);
	}

	@Override
	public int insertMessage(String confid, String openid, String message) {
		MessageConf messageConf = new MessageConf();
		messageConf.setConfid(confid);
		messageConf.setOpenid(openid);
		messageConf.setMessage(message);
		return messageConfMapper.insert(messageConf);
	}

}
