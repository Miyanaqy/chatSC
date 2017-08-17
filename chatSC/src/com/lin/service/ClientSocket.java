package com.lin.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.lin.dao.UserDao;
import com.lin.utils.Message;
import com.lin.utils.MessageQueue;
import com.lin.utils.User;

public class ClientSocket implements Runnable {
	public static final String EXIT = "EXIT";
	public static Set<ObjectOutputStream> clientStreamSet;
	//public static Set<Socket> socketSet;
	static {
		clientStreamSet = new HashSet<ObjectOutputStream>();
		//socketSet = new HashSet<Socket>();
	}
	private Socket socket;
	ObjectOutputStream oos = null;
	ObjectInputStream br = null;
	MessageQueue mq = null;
	public ClientSocket(Socket socket) throws IOException {
		this.socket = socket;
		//ClientSocket.socketSet.add(socket);
		this.br = new ObjectInputStream(this.socket.getInputStream());
		this.mq = MessageQueue.getMessageQueue("outMessageQueue");
		this.oos = new ObjectOutputStream(this.socket.getOutputStream());
		ClientSocket.clientStreamSet.add(this.oos);
		
	}
	@Override
	public void run() {
		Message message = new Message();
		Message rMessage = null;
		po:while(true) {
			try {
				message = (Message)br.readObject();
				
			} catch (Exception e) {
				System.out.println("失去客户端连接");
				e.printStackTrace();
				
			}
			System.out.println(message);
			System.out.println(message.getMessage());
			if(message == rMessage) {
				break po;
			}else {
				rMessage = message; 
			}
			switch(message.getMethod()) {
			case "register":
				
				break; 
			case "login":
				doLogin(message);
				break;
			case "message":
				doMessageGet(message);
				break;
			case "exit":
				break po;
			}
			
		}
		
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("bufferedReader关闭失败");
			e.printStackTrace();
		}
		try {
			ClientSocket.clientStreamSet.remove(oos);
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("客户端离开");
	}
	
	public void doLogin(Message message) {
		String username = message.getUsername();
		String password = message.getPassword();
		Message wMessage = new Message();
		try {
			User user = new UserDao().loginUser(username,password);
			if(user == null) {
				wMessage.setMethod("error");
				wMessage.setMessage("用户名密码错误");
			}else {
				wMessage.setMessage("Success");
				//wMessage.setUser(user);
				wMessage.setMessage("登陆成功，欢迎使用ChatSC");
			}
		} catch (SQLException e) {
			System.out.println("系统错误");
			e.printStackTrace();
		}
		try {
			oos.writeObject(wMessage);
			oos.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doMessageGet(Message message) {
		mq.add(message);
	}

}
