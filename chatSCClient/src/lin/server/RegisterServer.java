package lin.server;

import javax.swing.JOptionPane;

import com.lin.utils.Message;
import com.lin.utils.ReceiveMessage;
import com.lin.utils.SendMessage;
import com.lin.utils.User;

public class RegisterServer {
	
	public void register(String username, String password, String nickname) {
		Message message = new Message();
		Message rMessage = null;
		User user = new User();
		user.setNickname(nickname);
		message.setMethod("register").setUsername(username).setPassword(password).setUser(user);
		SendMessage.getSendMessage().send(message);
		rMessage = ReceiveMessage.getReceiveMessage().receive();
		if(rMessage.getMethod().equals("success")) {
			JOptionPane.showMessageDialog(null, rMessage.getMessage(), "注册成功", JOptionPane.ERROR_MESSAGE);
		}else if(rMessage.getMethod().equals("error")) {
			JOptionPane.showMessageDialog(null, rMessage.getMessage(), "注册失败", JOptionPane.ERROR_MESSAGE);
		}
	}
}
