package clientDemo;

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
		String line = null;
		Message message = null;
		Object obj = null;
		while(!this.exit) {
			
			try {
				obj = ois.readObject();
			} catch (Exception e) {
				System.out.println("��ȡMessageʧ��");
				break;
			}
			message = (Message) obj;
			line = message.getMessage();
			System.out.println(line);
		}
		try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
