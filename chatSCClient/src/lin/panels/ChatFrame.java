package lin.panels;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.lin.utils.ReceiveMessage;
import com.lin.utils.SendMessage;
import com.lin.utils.User;

import lin.server.ChatServer;
import lin.server.ServerListener;

public class ChatFrame extends JFrame {
	private Socket socket;
	private User user;
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		
		JButton exit = new JButton();
		exit.setSize(150, 70);
		exit.setLocation(600, 650);
		exit.setText("退出");
		add(exit);
		
		ServerListener sl = new ServerListener();
		sl.setChatPane(scroll);
		sl.setChatView(chatView);
		Thread thread = new Thread(sl);
		thread.start();
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = chatWindow.getText();
				chatWindow.setText("");
				if(text != null && !text.equals("")) {
					ChatServer cs = new ChatServer();
					cs.sendMessage(text, user);
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReceiveMessage.getReceiveMessage().close();
				SendMessage.getSendMessage().close();
				try {
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
	}
}
