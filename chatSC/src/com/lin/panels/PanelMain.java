package com.lin.panels;

import java.io.IOException;

import com.lin.service.ServiceLestener;

public class PanelMain {

	public static void main(String[] args) {
		ServiceLestener service = new ServiceLestener();
		try {
			service.init();
			System.out.println("服务器初始化完成");
		} catch (IOException e) {
			System.out.println("初始化失败");
			e.printStackTrace();
		}
		Thread thread = new Thread(service);
		thread.start();

	}

}
