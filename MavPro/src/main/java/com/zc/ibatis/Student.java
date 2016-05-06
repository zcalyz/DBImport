package com.zc.ibatis;

import java.sql.Date;

public class Student {
	private int sid;
	
	private String sname;
	
	private Date birth;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
}
