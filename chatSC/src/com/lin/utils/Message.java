package com.lin.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Message implements Serializable {
	private int userID;
	private String message;
	public Message next;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
