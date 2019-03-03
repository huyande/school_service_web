package com.school.schoolweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolweb.bean.Roast;
import com.school.schoolweb.dao.RoastMapper;
import com.school.schoolweb.service.RoastService;

@Service
public class RoastServiceImpl implements RoastService {

	@Autowired
	private RoastMapper roastMapper;

	//分页查找所有状态为1 的吐槽数据
	@Override
	public List<Roast> findRoaseDatas(Integer page, Integer pagesize) {
		return roastMapper.findRoaseDatas((page-1)*pagesize,pagesize);
	}

	@Override
	public int addRoast(Roast roast) {
		return roastMapper.insert(roast);
	}

	@Override
	public int deleteByRoastId(Integer roastid) {
		return roastMapper.deleteByRoastId(roastid);
	}

	@Override
	public List<Roast> findRoaseMyDatas(String openid, Integer page, Integer pagesize) {
		return roastMapper.findRoaseMyDatas(openid,(page-1)*pagesize,pagesize);
	}

	@Override
	public Roast findroastByRoastId(int roastid) {
		return roastMapper.findroastByRoastId(roastid);
	}
	
	
}
