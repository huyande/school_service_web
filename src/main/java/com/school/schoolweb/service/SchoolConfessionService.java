package com.school.schoolweb.service;

import java.util.List;

import com.school.schoolweb.bean.Confession;
import com.school.schoolweb.bean.SchoolImage;

public interface SchoolConfessionService {

	/**
	 * 添加表白信息
	* @author hyd
	* @Description: 
	* @date 2019年2月16日 下午2:26:40
	* @param confession
	* @return
	 */
	int postAdd(Confession confession);

	/**
	 * 查找表白信息
	* @author hyd
	* @Description: 
	* @date 2019年2月16日 下午2:26:14
	* @param page
	* @param size
	* @return
	 */
	List<Confession> findConfession(int page, int size);

	/**
	 *  查找我的表白信息
	* @author hyd
	* @Description: 
	* @date 2019年2月16日 下午2:26:02
	* @param page
	* @param pageSize
	* @param openid
	* @return
	 */
	List<Confession> findschoolConfessionOfMyLove(Integer page, Integer pageSize, String openid);
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
