package com.lin.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
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
		this.setSize(1020, 800);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JTextArea chatView = new JTextArea();
		chatView.setEditable(false);
		chatView.setLineWrap(true);
		chatView.setWrapStyleWord(true);
		chatView.setSize(740, 440);
		chatView.setBackground(Color.WHITE);
		chatView.setText("111");
		
		JScrollPane scroll = new JScrollPane(chatView); 
		scroll.setSize(740, 440);
		scroll.setLocation(40, 40);
		add(scroll);
		
		JTextArea chatWindow = new JTextArea();
		chatWindow.setSize(920, 100);
		chatWindow.setLocation(40, 490);
		add(chatWindow);
		
		
		JList<String> userList = new JList<String>();
		userList.setSize(140, 440);
		userList.setLocation(820, 40);
		add(userList);
		
		JButton enter = new JButton();
		enter.setSize(150, 70);
		enter.setLocation(200, 650);
		enter.setText("发送消息");
		add(enter);
		
		JButton clear = new JButton();
		clear.setSize(150, 70);
		clear.setLocation(600, 650);
		clear.setText("清空");
		add(clear);
		
		
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chatWindow.getText() != null || chatWindow.getText().equals("")) {
					int height = 20;
				    Point p = new Point();
				    p.setLocation(0, chatView.getLineCount() * height);
				    scroll.getViewport().setViewPosition(p);
				    chatView.append("\n" + chatWindow.getText());
				    chatWindow.setText("");
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChatFrame cf = new ChatFrame();
				System.out.println(cf.getContentPane().getComponents());
				for(Component co:cf.getRootPane().getContentPane().getComponents()) {
					System.out.println(co);
				}
			}
		});
	}
}
