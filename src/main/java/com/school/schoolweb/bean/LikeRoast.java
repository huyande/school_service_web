package com.school.schoolweb.bean;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-02-14
 */
public class LikeRoast {
    private Integer id;

    private Integer roastid;

    private String openid;

    private Integer liked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoastid() {
        return roastid;
    }

    public void setRoastid(Integer roastid) {
        this.roastid = roastid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getLiked() {
        return liked;
    }

    public void setLiked(Integer liked) {
        this.liked = liked;
    }
}