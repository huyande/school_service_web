package com.school.schoolweb.bean.ana;
import com.school.schoolweb.bean.Wxuserinfo;;
/**
 * 封装返回数据的json 数据对象
 * @author huyande
 *
 */
public class ScRoastJson {

	private int id; //吐槽 id
	
	private String content; //吐槽内容
	
	private String createtime;  //创建时间
	
	private int state; //显示状态  1 为显示   2 为不显示
	
	private Wxuserinfo user; //发布吐槽的用户信息

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Wxuserinfo getUser() {
		return user;
	}

	public void setUser(Wxuserinfo user) {
		this.user = user;
	}
	
}
