package com.school.schoolweb.dao;

import org.apache.ibatis.annotations.Param;

import com.school.schoolweb.bean.LikeRoast;
import com.school.schoolweb.bean.Roast;

public interface LikeRoastMapper {
    int insert(LikeRoast record);

    int insertSelective(LikeRoast record);

	int roastLikeCount(@Param(value = "roastid") Integer roastid);

	LikeRoast roastIsNotLiked(@Param(value = "openid") String openid, @Param(value = "roastid") Integer roastid);

	int updataRoastLikeState(@Param(value = "roastId") Integer roastId, @Param(value = "openid") String openid, @Param(value = "state") int state);

	LikeRoast isHasRoastLikeData(@Param(value = "roastId") Integer roastId, @Param(value = "openid") String openid);
}