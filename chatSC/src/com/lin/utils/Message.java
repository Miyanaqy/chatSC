package com.lin.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Message implements Serializable {
	private String addr;
	private String message;
	public Message next;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
