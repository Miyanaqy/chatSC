package lin.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.*;

import lin.utils.Message;

public class LoginFrame extends JFrame {
	public Socket socket;

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
		
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent eve) {
				ObjectInputStream ois = null;
				ObjectOutputStream oos = null;
				try {
					ois = new ObjectInputStream(socket.getInputStream());
					oos = new ObjectOutputStream(socket.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				Message message = new Message();
				Message rMessage = new Message();
				String username = userIn.getText();
				String password = passwordIn.getText();
				if(username == null || username.equals("")) {
					if(password == null || password.equals("")){
						JOptionPane.showMessageDialog(null, "�û������벻��Ϊ��", "��½����", JOptionPane.ERROR_MESSAGE); 
					}
				}
				message.setUsername(username);
				message.setPassword(password);
				message.setMethod("login");
				try {
				oos.writeObject(message);
				oos.flush();
				}catch(IOException e) {
					JOptionPane.showMessageDialog(null, "���ӳ�ʱ�����Ժ�����", "��½����", JOptionPane.ERROR_MESSAGE); 
					exit(ois, oos);
				}
				try {
					rMessage = (Message)ois.readObject();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "���ӳ�ʱ�����Ժ�����", "��½����", JOptionPane.ERROR_MESSAGE); 
					exit(ois, oos);
				}
				if(rMessage.getMethod().equals("success")) {
					
				}else if(rMessage.getMethod().equals("error")) {
					JOptionPane.showMessageDialog(null, rMessage.getMessage(), "��½����", JOptionPane.ERROR_MESSAGE); 
				}
			}
			
			
			void exit(ObjectInputStream ois, ObjectOutputStream oos) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
	}
	
	
	
}
