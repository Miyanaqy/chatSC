package lin.panels;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lin.utils.Message;
import com.lin.utils.SendMessage;
import com.lin.utils.User;

public class Register extends JFrame {
	
	public Register() {
		super();
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setSize(340, 340);
		this.setTitle("Register user");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel label_title = new JLabel("新用户注册", JLabel.CENTER);
		label_title.setSize(240, 60);
		label_title.setLocation(40, 0);
		add(label_title);
		
		JLabel label_username = new JLabel("用户名：");
		label_username.setSize(60, 30);
		label_username.setLocation(40, 80);
		add(label_username);
		
		JLabel label_password = new JLabel("密  码：");
		label_password.setSize(60, 30);
		label_password.setLocation(40, 130);
		add(label_password);
		
		JLabel label_nickname = new JLabel("昵  称：");
		label_nickname.setSize(60, 30);
		label_nickname.setLocation(40, 180);
		add(label_nickname);
		
		JTextField usernameIn = new JTextField();
		usernameIn.setSize(160, 30);
		usernameIn.setLocation(120, 80);
		add(usernameIn);
		
		JPasswordField passwordIn = new JPasswordField();
		passwordIn.setSize(160, 30);
		passwordIn.setLocation(120, 130);
		add(passwordIn);
		
		JTextField nicknameIn = new JTextField();
		nicknameIn.setSize(160, 30);
		nicknameIn.setLocation(120, 180);
		add(nicknameIn);
		
		JButton submit = new JButton("提交");
		submit.setSize(90, 40);
		submit.setLocation(40, 230);
		add(submit);
		
		JButton cancel = new JButton("返回");
		cancel.setSize(90, 40);
		cancel.setLocation(170, 230);
		add(cancel);
		
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Message message = new Message();
				User user = new User();
				String username = usernameIn.getText();
				String password = passwordIn.getText();
				String nickname = nicknameIn.getText();
				String text = "";
				boolean flag = true;
				if(username == null || username.equals("")) {
					flag = false;
					text += "用户名 ";
				}
				if(password == null || password.equals("")) {
					flag = false;
					text += "密码 ";
				}
				if(nickname == null || nickname.equals("")) {
					flag = false;
					text += "昵称 ";
				}
				
				if(flag) {
					user.setUsername(username).setNickname(nickname);
					message.setMethod("register").setUser(user).setPassword(password);
					Message rMessage = SendMessage.getSendMessage().send(message);
					if(rMessage.getMethod().equals("error")) {
						JOptionPane.showMessageDialog(null, rMessage.getMessage(), "注册失败", JOptionPane.ERROR_MESSAGE);
					}else if(rMessage.getMessage().equals("success")) {
						
					}
				}else {
					JOptionPane.showMessageDialog(null, text+"不能为空", "注册失败", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		cancel.addActionListener(new RegisterClose(this));
	}
	
	private class RegisterClose implements ActionListener {
		private Frame frame;
		public RegisterClose(Frame frame) {
			super();
			this.frame = frame;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			this.frame.dispose();
			
		}
	}

	
}
