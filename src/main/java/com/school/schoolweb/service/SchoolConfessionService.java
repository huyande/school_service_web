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
	/**
	 * 统计表白信息总数和新增数 
	 * @return
	 */
	String statisticalConfCountAndNewCount();
	/**
	 * 统计表白信息中性别比例
	 * @return
	 */
	String statisticalConfCountSex();
	/**
	 * 统计表白信息匿名实名比例 
	 * @return
	 */
	String statisticalConfCountStateIncognito();

	
}
