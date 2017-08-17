package lin.server;

import javax.swing.JOptionPane;

import com.lin.utils.Message;
import com.lin.utils.ReceiveMessage;
import com.lin.utils.SendMessage;
import com.lin.utils.User;

public class LoginServer {
	
	public void login(String username, String password) {
		
		Message message = new Message();
		Message rMessage = null;
		message.setMethod("login").setPassword(password).setUsername(username);
		SendMessage.getSendMessage().send(rMessage);
		rMessage = ReceiveMessage.getReceiveMessage().receive();
		if(rMessage.getMethod().equals("success")) {
			
		}else if(rMessage.getMethod().equals("error")) {
			JOptionPane.showMessageDialog(null, rMessage.getMessage(), "登陆失败", JOptionPane.ERROR_MESSAGE);
		}
	}
}
