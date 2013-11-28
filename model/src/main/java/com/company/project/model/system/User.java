package com.company.project.model.system;

import java.io.Serializable;

/**
 * 系统用户
 * @author 纪冉
 */
@SuppressWarnings("serial")
public class User implements Serializable{
	private int id;
	private String uname;
	private String pwd;
	private byte enabled;
	private String description;
	
	public User(){}
	public User(String uname, String pwd, byte enabled, String description) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.enabled = enabled;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public byte getEnabled() {
		return enabled;
	}
	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
