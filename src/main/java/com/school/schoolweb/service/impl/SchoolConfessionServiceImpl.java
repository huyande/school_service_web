package com.school.schoolweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolweb.bean.Confession;
import com.school.schoolweb.bean.SchoolImage;
import com.school.schoolweb.dao.ConfessionMapper;
import com.school.schoolweb.service.SchoolConfessionService;

@Service
public class SchoolConfessionServiceImpl implements SchoolConfessionService{

	@Autowired
	private ConfessionMapper confessionMapper;
	
	@Override
	public int postAdd(Confession confession) {
		return confessionMapper.insert(confession);
	}

	@Override
	public List<Confession> findConfession(int pageStart, int pageSize) {
		
		return confessionMapper.findAllConfession((pageStart-1)*pageSize,pageSize);
	}

	@Override
	public List<Confession> findschoolConfessionOfMyLove(Integer page, Integer pageSize, String openid) {
		return confessionMapper.findschoolConfessionOfMyLove((page-1)*pageSize,pageSize,openid);
	}

	@Override
	public Confession findConfessionByConfid(String confid) {
		return confessionMapper.selectByPrimaryKey(confid);
	}

	@Override
	public int deleteConfessionById(String confid) {
		return confessionMapper.deleteByPrimaryKey(confid);
	}

}
