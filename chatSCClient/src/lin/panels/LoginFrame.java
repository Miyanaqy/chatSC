package lin.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.*;

import lin.server.LoginServer;

public class LoginFrame extends JFrame {
	private Socket socket;
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public LoginFrame() {
		super();
		this.setTitle("ChatSC login");
		this.setLayout(null);
		this.setSize(320, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JLabel label_title = new JLabel();
		label_title.setText("用  户  登  录");
		label_title.setHorizontalAlignment(JLabel.CENTER);
		label_title.setFont(new Font("黑体", Font.BOLD, 20));
		label_title.setSize(200, 60);
		label_title.setLocation(40,0);
		add(label_title);
		
		JLabel label_user = new JLabel();
		label_user.setText("用户名：");
		label_user.setSize(60, 30);
		label_user.setLocation(40, 70);
		add(label_user);
		
		JLabel label_psd = new JLabel();
		label_psd.setText("密  码：");
		label_psd.setSize(60, 30);
		label_psd.setLocation(40, 110);
		add(label_psd);
		
		JTextField userIn = new JTextField();
		userIn.setSize(150, 30);
		userIn.setLocation(110, 70);
		add(userIn);
		
		JPasswordField passwordIn = new JPasswordField();
		passwordIn.setSize(150, 30);
		passwordIn.setLocation(110, 110);
		add(passwordIn);
		
		JButton submit = new JButton();
		submit.setText("登录");
		submit.setSize(80, 40);
		submit.setLocation(40, 160);
		add(submit);
		
		JButton register = new JButton();
		register.setText("注册");
		register.setSize(80, 40);
		register.setLocation(180, 160);
		add(register);
		
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Register rs = new Register();
				rs.setVisible(true);
				
			}
		});
		class SubmitListener implements ActionListener{
			private JFrame loginFrame;
			public SubmitListener(LoginFrame loginFrame) {
				this.loginFrame = loginFrame;
			}
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = userIn.getText();
				String password = passwordIn.getText();
				boolean flag = true;
				if(username == null || username.equals("")) {
					flag = false;
				}
				if(password == null || password.equals("")) {
					flag = false;
				}
				
				if(flag) {
					LoginServer login = new LoginServer();
					ChatFrame cf = login.login(username, password);
					if(cf != null) {
						cf.setVisible(true);
						cf.setSocket(socket);
						loginFrame.setVisible(false);
						loginFrame.dispose();
						
					}
				}else {
					JOptionPane.showMessageDialog(null, "用户名密码不能为空", "登录错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		submit.addActionListener(new SubmitListener(this));
	}
	
}
