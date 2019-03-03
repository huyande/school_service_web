package com.school.schoolweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolweb.bean.LikeRoast;
import com.school.schoolweb.bean.Roast;
import com.school.schoolweb.dao.LikeRoastMapper;
import com.school.schoolweb.service.RoastLikeService;

@Service
public class RoastLikeServiceImpl implements RoastLikeService {

	@Autowired
	private LikeRoastMapper likeRoastMapper;

	@Override
	public int roastLikeCount(Integer roastid) {
		return likeRoastMapper.roastLikeCount(roastid);
	}

	@Override
	public int roastIsNotLiked(String openid, Integer roastid) {
		LikeRoast likeRoast = likeRoastMapper.roastIsNotLiked(openid,roastid);
		return likeRoast==null?0:1;
	}

	@Override
	public int updataRoastLikeState(Integer roastId, String openid, int state) {
		return likeRoastMapper.updataRoastLikeState(roastId,openid,state);
	}

	@Override
	public LikeRoast isHasRoastLikeData(Integer roastId, String openid) {
		return likeRoastMapper.isHasRoastLikeData(roastId,openid);
	}

	@Override
	public int addRoastLikeData(LikeRoast like_roast) {
		return likeRoastMapper.insert(like_roast);
	}
}
