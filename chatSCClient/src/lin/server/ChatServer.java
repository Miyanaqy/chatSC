package lin.server;

import java.util.Date;

import com.lin.utils.Message;
import com.lin.utils.SendMessage;
import com.lin.utils.User;

public class ChatServer {
	public void sendMessage(String text, User user) {
		Message message = new Message();
		Message rMessage = null;
		message.setMethod("message").setMessage(text).setUser(user).setDate(new Date());
		SendMessage.getSendMessage().send(message);
	}
	
}
