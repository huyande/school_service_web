package com.school.schoolweb.dao;

import com.school.schoolweb.bean.UserCount;

public interface UserCountMapper {
    UserCount findbyId();
    void updataUserCount(int count);
}
