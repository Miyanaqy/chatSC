package lin.server;

import java.awt.Point;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.lin.utils.Message;
import com.lin.utils.ReceiveMessage;

import lin.panels.ChatFrame;
public class ServerListener implements Runnable {
	private JScrollPane chatPane;
	private JTextArea chatView;
	public volatile boolean exit =false;
	private ObjectInputStream ois;
	public JTextArea getChatView() {
		return chatView;
	}
	public void setChatView(JTextArea chatView) {
		this.chatView = chatView;
	}
	
	
	
	public JScrollPane getChatPane() {
		return chatPane;
	}
	public void setChatPane(JScrollPane chatPane) {
		this.chatPane = chatPane;
		
	}
	public ObjectInputStream getOis() {
		return ois;
	}
	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}
	@Override
	public void run() {
		Message message = null;
		while(!this.exit) {
			message = ReceiveMessage.getReceiveMessage().receive();
			String text1 = "\n" + message.getUser().getNickname() + ":\n";
			String text2 = message.getMessage();
			int height = 20;
			Point p = new Point();
			p.setLocation(0, chatView.getLineCount() * height);
			chatPane.getViewport().setViewPosition(p);
			chatView.append(text1 + text2);
		}
		
		try {
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("断开服务器连接");
	}

}
