package com.school.schoolweb.bean.ana;

import java.util.List;

/**
 * 表白信息JSON
 * 
 * @author Administrator
 *
 */
public class ScConfessionJson {

	// 数据id
	private String id;
	// 内容
	private String content;
	// 发表时间
	private String time;
	// 点赞数据量
	private Integer likedCount;

	// 是否匿名
	private Integer stateNiming;

	// 用户信息
	private User user;

	// 图片列表
	private String image;
	
	//统计的数量
	private int numCount;
	
	//状态 
	private int state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getLikedCount() {
		return likedCount;
	}

	public void setLikedCount(Integer likedCount) {
		this.likedCount = likedCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getStateNiming() {
		return stateNiming;
	}

	public void setStateNiming(Integer stateNiming) {
		this.stateNiming = stateNiming;
	}

	public int getNumCount() {
		return numCount;
	}

	public void setNumCount(int numCount) {
		this.numCount = numCount;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
