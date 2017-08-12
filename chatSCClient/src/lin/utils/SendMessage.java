package lin.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SendMessage {
	private static SendMessage sm = null;
	private Socket socket = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	private SendMessage(Socket socket) {
		this.socket = socket;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SendMessage getSendMessage(Socket socket) {
		if(sm == null) {
			sm = new SendMessage(socket);
		}
		return sm;
	}
	
	public static SendMessage getSendMessage() {
		return getSendMessage(sm.socket);
	}
	
	public Message send(Message message) {
		Message rMessage = new Message();
		try {
			oos.writeObject(message);
			oos.flush();
		}catch(IOException e) {
			rMessage.setMethod("error").setMessage("连接服务器超时，请稍后再试");
			
		}
		try {
			rMessage = (Message)ois.readObject();
		} catch (Exception e) {
			rMessage.setMethod("error").setMessage("连接服务器超时请稍后再试");
		}
		return rMessage;
	}
	

}
