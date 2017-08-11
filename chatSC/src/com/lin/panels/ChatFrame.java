package com.lin.panels;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

public class ChatFrame extends JFrame {
	
	public ChatFrame() {
		super();
		this.setTitle("ChatSC");
		this.setSize(600, 800);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel chatView = new JLabel();
		chatView.setSize(250, 400);
		chatView.setLocation(70, 70);
		chatView.setBackground(Color.WHITE);
		chatView.setText("111");
		add(chatView);
		
		JTextArea chatWindow = new JTextArea();
		chatWindow.setSize(460, 100);
		chatWindow.setLocation(70, 520);
		add(chatWindow);
		
		
		JList<String> userList = new JList<String>();
		userList.setSize(140, 400);
		userList.setLocation(390, 70);
		add(userList);
		
		JButton enter = new JButton();
		enter.setSize(150, 70);
		enter.setLocation(100, 650);
		enter.setText("������Ϣ");
		add(enter);
		
		JButton clear = new JButton();
		clear.setSize(150, 70);
		clear.setLocation(350, 650);
		clear.setText("���");
		add(clear);
		
	}
}
