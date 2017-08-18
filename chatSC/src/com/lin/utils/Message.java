package com.lin.utils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Message implements Serializable {
	private String method;
	private User user;
	private String message;
	private String password;
	private String username;
	private String date;
	public Message next;
	
	
	public Date getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = null;
		try {
			currentTime = formatter.parse(this.date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return currentTime;
	}
	public Message setDate(Date date) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.date = formatter.format(currentTime);
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Message setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getUsername() {
		return username;
	}
	public Message setUsername(String username) {
		this.username = username;
		return this;
	}
	public User getUser() {
		return user;
	}
	public Message setUser(User user) {
		this.user = user;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public Message setMessage(String message) {
		this.message = message;
		return this;
	}
	public String getMethod() {
		return method;
	}
	public Message setMethod(String method) {
		this.method = method;
		return this;
	}
	
}
