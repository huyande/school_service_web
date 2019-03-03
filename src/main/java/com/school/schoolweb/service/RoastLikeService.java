package com.school.schoolweb.service;

import com.school.schoolweb.bean.LikeRoast;
import com.school.schoolweb.bean.Roast;

public interface RoastLikeService {

	int roastLikeCount(Integer roastid);

	int roastIsNotLiked(String openid, Integer roastid);

	int updataRoastLikeState(Integer roastId, String openid, int i);

	LikeRoast isHasRoastLikeData(Integer roastId, String openid);

	int addRoastLikeData(LikeRoast like_roast);
}
