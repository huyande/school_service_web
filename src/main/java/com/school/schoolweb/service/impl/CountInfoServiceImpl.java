package com.school.schoolweb.service.impl;

import com.school.schoolweb.dao.ConfessionMapper;
import com.school.schoolweb.dao.CountInfoMapper;
import com.school.schoolweb.dao.RoastMapper;
import com.school.schoolweb.dao.WxuserinfoMapper;
import com.school.schoolweb.service.CountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountInfoServiceImpl implements CountInfoService{
    @Autowired
    private CountInfoMapper userCountMapper;

    @Autowired
    private WxuserinfoMapper wxuserinfoMapper;
    
    @Autowired
    private ConfessionMapper confessionMapper;
    
    @Autowired
    private RoastMapper roastMapper;

    /**
     * 进行更新操作
     */
    @Override
    public void updataCountInfo(String type) {
    	if(type.equals("wxuser")){
    		userCountMapper.updataCountInfo(wxuserinfoMapper.getUserCount(),type);
    	}else if(type.equals("conf")){
    		userCountMapper.updataCountInfo(confessionMapper.countItem(),type);
    	}else if(type.equals("roast")){
    		userCountMapper.updataCountInfo(roastMapper.countItem(),type);
    	}
    }
}
