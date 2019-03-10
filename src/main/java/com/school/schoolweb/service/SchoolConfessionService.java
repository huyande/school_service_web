package com.school.schoolweb.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.Confession;
import com.school.schoolweb.bean.SchoolImage;
import com.school.schoolweb.bean.ana.ScConfessionJson;

public interface SchoolConfessionService {

	PageInfo<ScConfessionJson> findAllConfess(Integer currentpage, Integer pagesize);

	/**
	 * 根据文章id 查询此信息
	 * @param confid
	 * @return
	 */
	Confession findConfessionByConfid(String confid);
	/**
	 * 更具id删除表白信息
	 */
	int deleteConfessionById(String confid);

	
}
