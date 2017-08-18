package lin.server;

import javax.swing.JOptionPane;

import com.lin.utils.Message;
import com.lin.utils.ReceiveMessage;
import com.lin.utils.SendMessage;

import lin.panels.ChatFrame;

public class LoginServer {
	
	public ChatFrame login(String username, String password) {
		
		Message message = new Message();
		Message rMessage = null;
		ChatFrame cf = null;
		message.setMethod("login").setPassword(password).setUsername(username);
		SendMessage.getSendMessage().send(message);
		rMessage = ReceiveMessage.getReceiveMessage().receive();
		if(rMessage.getMethod().equals("success")) {
			JOptionPane.showMessageDialog(null, rMessage.getMessage(), "登陆成功", JOptionPane.ERROR_MESSAGE);
			cf = new ChatFrame();
			cf.setUser(rMessage.getUser());
			
		}else if(rMessage.getMethod().equals("error")) {
			JOptionPane.showMessageDialog(null, rMessage.getMessage(), "登陆失败", JOptionPane.ERROR_MESSAGE);
		}
		return cf;
	}
}
