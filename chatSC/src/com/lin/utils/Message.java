package com.lin.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Message implements Serializable {
	private String method;
	private User user;
	private String message;
	private String password;
	private String username;
	private String date;
	public Message next;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
