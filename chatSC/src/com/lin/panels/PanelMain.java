package com.lin.panels;

import java.io.IOException;

import com.lin.service.ServerController;
import com.lin.service.ServiceListener;
import com.lin.service.WriteToClient;

public class PanelMain {

	public static void main(String[] args) {
		ServiceListener service = new ServiceListener();
		try {
			service.init();
			System.out.println("服务器初始化完成");
		} catch (IOException e) {
			System.out.println("初始化失败");
			e.printStackTrace();
		}
		WriteToClient wtc = new WriteToClient();
		Thread thread0 = new Thread(wtc);
		thread0.start();
		ServerController sc = new ServerController();
		Thread thread1 = new Thread(sc);
		thread1.start();
		Thread thread2 = new Thread(service);
		thread2.start();
		
		ChatFrame cf = new ChatFrame();
		cf.setVisible(true);
	}

}
