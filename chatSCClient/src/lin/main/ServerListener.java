package lin.main;

import java.io.IOException;
import java.io.ObjectInputStream;

import com.lin.utils.Message;
public class ServerListener implements Runnable {
	public volatile boolean exit =false;
	private ObjectInputStream ois = null;
	

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
			
			try {
				message =(Message) ois.readObject();
			} catch (Exception e) {
				break;
			}
			System.out.println(message.getMessage());
		}
		
		try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("断开服务器连接");
	}

}
