package com.school.schoolweb.bean;


/**
 * @author Administrator
 *
 */
public class Confession {
    private String id;

    private String content;

    private String time;

    private String image;

    private String openid;
    
    private Integer state;
    
    private Integer stateniming;
    
    private String touser;
    private String fromuser;
    
    //统计前十点赞量 需要的参数
    private int numCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getStateniming() {
		return stateniming;
	}

	public void setStateniming(Integer stateniming) {
		this.stateniming = stateniming;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getFromuser() {
		return fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}

	public int getNumCount() {
		return numCount;
	}

	public void setNumCount(int numCount) {
		this.numCount = numCount;
	}
}