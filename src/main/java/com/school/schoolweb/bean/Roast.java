package com.school.schoolweb.bean;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-02-14
 */
public class Roast {
    private Integer id;

    private String openid;

    private String content;

    private String createtime;

    /**
     * 卡片背景颜色
     */
    private Integer backgroupcolor;

    /**
     * 1 通过显示 、2 不显示
     */
    private Integer state;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getBackgroupcolor() {
        return backgroupcolor;
    }

    public void setBackgroupcolor(Integer backgroupcolor) {
        this.backgroupcolor = backgroupcolor;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}