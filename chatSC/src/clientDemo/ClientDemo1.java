package clientDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo1 {
	
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame();
		lf.setVisible(true);
		try {
			lf.socket= new Socket("127.0.0.1", 5506);
		} catch (Exception e) {
			System.out.println("无法连接的服务器");
			System.exit(0);
		}
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
