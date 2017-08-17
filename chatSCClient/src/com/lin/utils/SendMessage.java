package com.lin.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SendMessage {
	public static SendMessage sm = null;
	private Socket socket;
	private ObjectOutputStream oos;
	
	private SendMessage(Socket socket, ObjectOutputStream oos) {
		this.socket = socket;
		this.oos = oos;
	}
	
	public static SendMessage createSendMessage(Socket socket, ObjectOutputStream oos) {
		if(sm == null) {
			sm = new SendMessage(socket, oos);
		}
		return sm;
	}
	public static SendMessage getSendMessage() {
		return sm;
	}
	public void send(Message message) {
		try {
			oos.writeObject(message);
			oos.flush();
			oos.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		try {
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
