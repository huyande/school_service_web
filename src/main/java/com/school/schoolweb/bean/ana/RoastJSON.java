package com.school.schoolweb.bean.ana;

public class RoastJSON {
	
	private Integer id;

    private String content;
    
    /**
     * 卡片背景颜色
     */
    private Integer backgroupcolor;
    
    //点赞数量
    private Integer likeCount;
    
    //留言数量
    private Integer messageCount;
    
    private String createtime;
    
	private User user;
	
	private int numCount;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNumCount() {
		return numCount;
	}

	public void setNumCount(int numCount) {
		this.numCount = numCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getBackgroupcolor() {
		return backgroupcolor;
	}

	public void setBackgroupcolor(Integer backgroupcolor) {
		this.backgroupcolor = backgroupcolor;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}
