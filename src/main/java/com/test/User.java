package com.test;
public class User {
	int u_id;
	String name;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", name=" + name + "]";
	}
	

}
