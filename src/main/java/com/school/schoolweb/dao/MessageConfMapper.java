package com.school.schoolweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.school.schoolweb.bean.MessageConf;

public interface MessageConfMapper {

	List<MessageConf> getconfMessageList(@Param(value = "confid") String confid, @Param(value = "pageStart") int pageStart, @Param(value = "pageSize") int pageSize);

	int countItem(String confid);

	int insert(MessageConf messageConf);

}
