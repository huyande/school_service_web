package com.school.schoolweb.service.impl;

import com.school.schoolweb.dao.UserCountMapper;
import com.school.schoolweb.dao.WxuserinfoMapper;
import com.school.schoolweb.service.UserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UserCountServiceImpl implements UserCountService{
    @Autowired
    private UserCountMapper userCountMapper;

    @Autowired
    private WxuserinfoMapper wxuserinfoMapper;

    /**
     * 进行更新操作
     */
    @Override
    public void updataUserCount() {
        userCountMapper.updataUserCount(wxuserinfoMapper.getUserCount());
    }
}
