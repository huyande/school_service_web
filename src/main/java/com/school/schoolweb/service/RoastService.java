package com.school.schoolweb.service;

import java.util.List;

import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;
import com.school.schoolweb.bean.Roast;
import com.school.schoolweb.bean.ana.RoastJSON;
import com.school.schoolweb.bean.ana.ScRoastJson;

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
	
	/**
	 * 吐槽新增和总数
	 * @return
	 */
	String roastCountInfo();

	/**
	 * 查询点赞前多少条的吐槽信息
	 * @param itemCount
	 * @return
	 */
	List<RoastJSON> findConfessionsOrderByItem(int itemCount);

	/**
	 * 分页查询所有的吐槽信息
	 * @param currentpage
	 * @param pagesize
	 * @param search
	 * @return
	 */
	String findAllRoast();
	
	/**
	 * 统计吐槽信息性别比例
	 * @return
	 */
	String statisticalRoastCountSex();
	/**
	 * 修改吐槽信息的状态 
	 * @param roastId
	 * @param stutas
	 * @return
	 */
	String changeRoastStatus(int roastId, int stutas);
	
	/**
	 * 查询新增数和总数吐槽 封装到 model 里 
	 * @param model
	 */
	void roastNewAndIncCount(Model model);

	/**
	 * 分页查询吐槽信息
	 * @param currentpage
	 * @param pagesize
	 * @param search
	 * @return
	 */
	PageInfo<ScRoastJson> findAllRoastList(Integer currentpage, Integer pagesize, String search);
}
