package com.school.schoolweb.service;

import java.util.List;

import com.school.schoolweb.bean.Roast;

/**
 * 吐槽 service
* @version:
* @Description: 
* @author: hyd 
* @date: 2019年2月14日 下午5:29:05
 */
public interface RoastService {

	List<Roast> findRoaseDatas(Integer page, Integer pagesize);

	int addRoast(Roast roast);

	int deleteByRoastId(Integer roastid);

	/**
	 * 查询我的吐槽列表
	* @author hyd
	* @Description: 
	* @date 2019年2月16日 下午3:28:01
	* @param openid
	* @param page
	* @param pagesize
	* @return
	 */
	List<Roast> findRoaseMyDatas(String openid, Integer page, Integer pagesize);

	Roast findroastByRoastId(int roastid);

}
