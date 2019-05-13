package com.school.schoolweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.school.schoolweb.bean.Roast;
import com.school.schoolweb.bean.otherbean.SexCount;

public interface RoastMapper {
    int insert(Roast record);

    int insertSelective(Roast record);

	List<Roast> findRoaseDatas(@Param(value = "pageStart") int pageStart, @Param(value = "pageSize") int pageSize);

	int deleteByRoastId(@Param(value = "roastid") Integer roastid);

	List<Roast> findRoaseMyDatas(String openid, @Param(value = "pageStart") int pageStart, @Param(value = "pageSize") int pageSize);

	Roast findroastByRoastId(@Param(value = "roastid") int roastid);

	int countItem();

	List<Roast> findConfessionsOrderByItem(int itemCount);

	/**
	 * 根据搜索内容  查询吐槽信息
	 * @param search
	 * @return
	 */
	List<Roast> findAllRoast();
	/**
	 * 查询男女未知个数
	 * @return
	 */
	List<SexCount> statisticalRoastCountSex();

	/**
	 * 修改吐槽信息的状态
	 * @param roastId
	 * @param stutas
	 * @return
	 */
	int changeRoastStatus(@Param(value = "roastId") int roastId, @Param(value = "stutas")int stutas);

	List<Roast> findAllRoastList(@Param(value = "search")  String search);

	int countItemSearch(@Param(value = "search") String search);
}