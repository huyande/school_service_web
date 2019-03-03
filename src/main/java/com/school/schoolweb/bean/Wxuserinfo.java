package com.school.schoolweb.bean;

/**
 * huyande
 * @date 2018-11-10
 */
public class Wxuserinfo {
    private Integer id;

    private String openid;

    private String nickname;

    private String avatarurl;

    private String province;

    private String city;

    private Integer gender;

    private String email;

    private String phonenumber;

    private String signtime ;

    private String recenttime;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSigntime() {
        return signtime;
    }

    public void setSigntime(String signtime) {
        this.signtime = signtime;
    }

    public String getRecenttime() {
        return recenttime;
    }

    public void setRecenttime(String recenttime) {
        this.recenttime = recenttime;
    }

    @Override
	public String toString() {
		return "Wxuserinfo [id=" + id + ", openid=" + openid + ", nickname=" + nickname + ", avatarurl=" + avatarurl
				+ ", province=" + province + ", city=" + city + ", gender=" + gender + "]";
	}
}