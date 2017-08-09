package com.lin.service;

import java.io.IOException;
import java.io.ObjectOutputStream;

import com.lin.utils.Message;
import com.lin.utils.MessageQueue;

public class WriteToClient implements Runnable {
	public MessageQueue messageQueue;
	public WriteToClient() {
		messageQueue = MessageQueue.getMessageQueue("inMessageQueue");
	}
	@Override
	public void run() {
		Message message = null;
		//ObjectOutputStream oos;
		while(true) {
			message = messageQueue.read();
			if(message == null) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				//MessageSeria ms = new MessageSeria();
				//ms.setAddr("03231630");
				//ms.setMessage("这是信息");
				for(ObjectOutputStream os:ClientSocket.clientStreamSet) {
					try {
						//oos = new ObjectOutputStream(socket.getOutputStream());
						//oos.writeObject(message);
						//oos.flush();
						System.out.println(message.getMessage());
						os.writeObject(message);
						os.flush();
						os.reset();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		}
		
	}

}
