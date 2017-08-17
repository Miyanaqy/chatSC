package clientDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.lin.utils.Message;
import com.lin.utils.User;

import clientDemo.ServerListener;

public class ClientDemo1 {
	
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 5506);
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Scanner in= new Scanner(System.in);
		
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		ServerListener sl = new ServerListener();
		sl.setOis(ois);
		Thread thread = new Thread(sl);
		thread.start();
		System.out.println(oos);
		Message message = new Message();
		User user = new User();
		String line = "";
		while(!line.equals("EXIT")) {
			line = in.nextLine();
			user.setNickname("Miqy").setUserID(3);
			message.setMethod("message").setMessage(line).setUser(user);
			oos.writeObject(message);
			oos.flush();
			oos.reset();
		}
			oos.close();
			socket.close();
		
	}
	
	public static void center() throws IOException {
		Socket socket = null;
		ObjectInputStream ois = null;
		BufferedReader out = null;
		PrintWriter write = null;
		String line ="";
		try {
			socket = new Socket();
		} catch (Exception e) {
			System.out.println("客户端连接失败");
			e.printStackTrace();
		}
		ois = new ObjectInputStream(socket.getInputStream());
		ServerListener sl = new ServerListener();
		sl.setOis(ois);
		Thread thread = new Thread(sl);
		thread.start();
		
		out = new BufferedReader(new InputStreamReader(System.in));
		write = new PrintWriter(socket.getOutputStream());
		line = out.readLine();
		try {
		while(!line.equals("EXIT")) {
			write.println(line);
			write.flush();
			line = out.readLine();
		}
		}catch(Exception e){
		}finally {
			write.println("EXIT");
			write.flush();
		}
		//sl.exit = true;
		write.close();
		out.close();
	}
	
}
