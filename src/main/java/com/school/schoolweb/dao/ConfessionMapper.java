package com.school.schoolweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.school.schoolweb.bean.Confession;
import com.school.schoolweb.bean.otherbean.IncognitoCount;
import com.school.schoolweb.bean.otherbean.SexCount;

public interface ConfessionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Confession record);

    int insertSelective(Confession record);

    Confession selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Confession record);

    int updateByPrimaryKey(Confession record);

	List<Confession> findAllConfess(@Param(value="search")  String search);

	int countItem();
	//统计男女表白信息比例 
	List<SexCount> statisticalConfCountSex();
	//统计发信息 的实名匿名比例
	List<IncognitoCount> statisticalConfCountStateIncognito();
	//根据某列排序 查询前itemCount条
	List<Confession> findConfessionsOrderByItem(int itemCount);

	//搜索结果数量统计
	int countItemSearch(@Param(value="search") String search);

	//修改表白信息状态
	int changeConfessionStatus(@Param(value="confid")String confid,@Param(value="stutas") int stutas);

}