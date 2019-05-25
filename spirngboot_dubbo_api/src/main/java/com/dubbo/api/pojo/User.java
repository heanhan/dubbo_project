/**
 * 
 */
package com.dubbo.api.pojo;

import java.awt.Menu;
import java.io.Serializable;
import java.util.List;


/**
 * @author Thunisoft
 *
 */
public class User implements Serializable {

	private int userid;// id

	private String username;// 姓名

	private String password;// 密码

	private String descript;
	
	private List<Menu> menus;//权限菜单列表

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(int userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", descript=" + descript
				+ "]";
	}

	

}
