package com.thales.airlab.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


/**
 * Function as a valueObject contains the user id and password submit.
 * 
 * 
 * Usage: 
 * 
 * To retrieve a record 
 * 		User.getUserId().equals(...);
 * 		User.getPassword().equals(..);
 * 
 * 
 * @author Alex
 * 
 * */
public class User implements Serializable {
	
	@NotNull(message = "UserId may not be null")
	private String userId;
	
	@NotNull(message = "Password may not be null")
	private String pwd;
	
	public User(String userId, String pwd) {
		this.userId = userId;
		this.pwd = pwd;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
