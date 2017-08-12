package com.lin.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceListener implements Runnable {
	private ServerSocket server;
	
	public void init() throws IOException {
		this.server = new ServerSocket(5506);
		
	}
	@Override
	public void run() {
		Socket socket = null;
		ClientSocket clientSocket = null;
		while(true) {
			try {
				System.out.println("等待客户端连接");
				socket = this.server.accept();
				System.out.println("客户端连接成功");
				
			} catch (IOException e) {
				System.out.println("连接失败");
				e.printStackTrace();
			}
			try {
				clientSocket = new ClientSocket(socket);
			} catch (IOException e) {
				System.out.println("初始化错误");
				e.printStackTrace();
			}
			Thread thread = new Thread(clientSocket);
			thread.start();
		}
		
	}
	
}
