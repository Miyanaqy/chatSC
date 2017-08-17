package com.lin.panels;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatFrame extends JFrame {
	public static void main(String[] args) {
		ChatFrame chat = new ChatFrame();
		chat.setVisible(true);
	}
	public ChatFrame() {
		super();
		this.setTitle("ChatSC");
		this.setSize(600, 800);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JTextArea chatView = new JTextArea();
		chatView.setSize(300, 400);
		chatView.setBackground(Color.WHITE);
		chatView.setText("111");
		JScrollPane scroll = new JScrollPane(chatView); 
		scroll.setSize(300, 400);
		scroll.setLocation(70, 70);
		add(scroll);
		
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
		
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chatView.append("\ndddd");
				
			}
		});
	}
}
