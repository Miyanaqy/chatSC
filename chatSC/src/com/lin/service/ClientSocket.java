package com.lin.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.lin.utils.Message;

public class ClientSocket implements Runnable {
	private static final String EXIT = "EXIT";
	private Socket socket;
	BufferedReader br = null;
	public ClientSocket(Socket socket) throws IOException {
		this.socket = socket;
		br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
	}
	@Override
	public void run() {
		String line = "�Ѿ�����";
		Message message = new Message();
		while(!(line.equals(ClientSocket.EXIT))) {
			message.setAddr(socket.getLocalAddress().toString());
			message.setMessage(line);
			try {
				line = br.readLine();
			} catch (IOException e) {
				System.out.println("���ݻ�ȡʧ��");
				e.printStackTrace();
			}
			
			
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�ͻ����뿪");
	}

}