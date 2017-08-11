package clientDemo;

import javax.swing.*;

public class LoginFrame extends JFrame {
	
	public LoginFrame() {
		super();
		this.setTitle("ChatSC login");
		this.setLayout(null);
		this.setSize(300, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JLabel label_title = new JLabel();
		label_title.setText("�û���¼");
		label_title.setSize(200, 60);
		label_title.setLocation(40,0);
		add(label_title);
		
		JLabel label_user = new JLabel();
		label_user.setText("�û���");
		label_user.setSize(60, 30);
		label_user.setLocation(40, 70);
		add(label_user);
		
		JLabel label_psd = new JLabel();
		label_psd.setText("����");
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
		submit.setText("��¼");
		submit.setSize(80, 40);
		submit.setLocation(40, 160);
		add(submit);
		
		JButton register = new JButton();
		register.setText("ע��");
		register.setSize(80, 40);
		register.setLocation(180, 160);
		add(register);
	}
	
}
