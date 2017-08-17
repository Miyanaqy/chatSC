package com.lin.utils;

import java.io.Serializable;

public class User implements Serializable {
private int userID;
private String username;
private String Nickname;
public int getUserID() {
	return userID;
}
public User setUserID(int userID) {
	this.userID = userID;
	return this;
}
public String getUsername() {
	return username;
}
public User setUsername(String username) {
	this.username = username;
	return this;
}
public String getNickname() {
	return Nickname;
}
public User setNickname(String nickname) {
	Nickname = nickname;
	return this;
}

}
