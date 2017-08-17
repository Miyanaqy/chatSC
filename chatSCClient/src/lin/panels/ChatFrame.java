package lin.panels;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

import com.lin.utils.User;

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
		enter.setText("发送消息");
		add(enter);
		
		JButton exit = new JButton();
		exit.setSize(150, 70);
		exit.setLocation(350, 650);
		exit.setText("清空");
		add(exit);
		
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}
}
