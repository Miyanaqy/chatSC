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
				System.out.println("�ȴ��ͻ�������");
				socket = this.server.accept();
				System.out.println("�ͻ������ӳɹ�");
				
			} catch (IOException e) {
				System.out.println("����ʧ��");
				e.printStackTrace();
			}
			try {
				clientSocket = new ClientSocket(socket);
			} catch (IOException e) {
				System.out.println("��ʼ������");
				e.printStackTrace();
			}
			Thread thread = new Thread(clientSocket);
			thread.start();
		}
		
	}
	
}
