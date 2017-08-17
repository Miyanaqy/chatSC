package com.lin.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReceiveMessage {
	private static ReceiveMessage rm;
	private Socket socket;
	private ObjectInputStream ois;
	
	private ReceiveMessage(Socket socket, ObjectInputStream ois) {
		this.socket = socket;
		this.ois = ois;
	}
	public static ReceiveMessage createReceiveMessage(Socket socket, ObjectInputStream ois) {
		if(rm == null) {
			rm = new ReceiveMessage(socket, ois);
		}
		return rm;
	}
	public static ReceiveMessage getReceiveMessage() {
		return rm;
	}
	
	public Message receive(){
		Message message = null;
		try {
			message = (Message) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public void close() {
		try {
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
