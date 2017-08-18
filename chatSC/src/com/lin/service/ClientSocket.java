package com.lin.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.lin.dao.RegisterDao;
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
			if(message == rMessage) {
				break po;
			}else {
				rMessage = message; 
			}
			switch(message.getMethod()) {
			case "register":
				try {
					doRegister(message);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	
	public void doRegister(Message message) {
		String username = message.getUsername();
		String password = message.getPassword();
		String nickname = message.getUser().getNickname();
		Message wMessage = new Message();
		RegisterDao register = new RegisterDao();
		try {
		if(!register.queryUsername(username)){
			if(!register.queryNickname(nickname)) {
				register.insertUser(username, password, nickname);
				wMessage.setMethod("success").setMessage("注册成功，欢迎使用chatSC聊天室，请登录后使用哦~");
			}else {
				wMessage.setMethod("error").setMessage("昵称已被注册");
			}
		}else {
			wMessage.setMethod("error").setMessage("用户名已被注册");
		}
		} catch (Exception e) {
			System.out.println("系统错误");
			e.printStackTrace();
		}
		try {
			oos.writeObject(wMessage);
			oos.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doLogin(Message message) {
		String username = message.getUsername();
		String password = message.getPassword();
		Message wMessage = new Message();
		try {
			User user = new UserDao().loginUser(username,password);
			if(user == null) {
				wMessage.setMethod("error").setMessage("用户名密码错误");
			}else {
				wMessage.setMethod("success");
				wMessage.setUser(user);
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
	}
	
	public void doMessageGet(Message message) {
		mq.add(message);
	}

}
