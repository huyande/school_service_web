package com.school.schoolweb.bean;

import java.util.Date;

/**
 * 
 * @date 2019-02-14
 */
public class MessageRoast {
    private Integer id;

    private String openid;

    private Integer roastid;

    private String message;

    private String createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getRoastid() {
        return roastid;
    }

    public void setRoastid(Integer roastid) {
        this.roastid = roastid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}