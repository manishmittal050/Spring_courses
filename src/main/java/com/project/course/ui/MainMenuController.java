package com.project.course.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.course.controller.LogInController;
import com.project.course.dto.UserDto;

@Controller
public class MainMenuController implements ActionListener{
	
	@Autowired
	private LogInController logInController;
	
	JFrame f=new JFrame("Log in");
	JTextField userName;
	JPasswordField password;
	JButton logInBtn = new JButton("Log in");
	JButton clearBtn = new JButton("Clear");
	
	public void prepareAndOpenFrame()
	{

		userName = new JTextField();
		userName.setBounds(128, 28, 186, 40);
        f.getContentPane().add(userName);
        userName.setColumns(10);
         
        JLabel userNameLbl = new JLabel("Name");
        userNameLbl.setBounds(65, 31, 146, 40);
        f.getContentPane().add(userNameLbl);
        
        
        
        password = new JPasswordField();
        password.setBounds(128, 88, 186, 40);
        f.getContentPane().add(password);
        password.setColumns(10);
         
        JLabel passwordLbl = new JLabel("Password");
        passwordLbl.setBounds(65, 91, 146, 40);
        f.getContentPane().add(passwordLbl);
		
       
        
        logInBtn.setBackground(Color.BLACK);
        logInBtn.setForeground(Color.BLACK);
        logInBtn.setBounds(70, 160, 80, 30);
        f.add(logInBtn);
        
        
        clearBtn.setBackground(Color.BLACK);
        clearBtn.setForeground(Color.BLACK);
        clearBtn.setBounds(188, 160, 80, 30);
        f.add(clearBtn);
        
        logInBtn.addActionListener(this);
        clearBtn.addActionListener(this);
		

		
		
		    
		f.setBounds(100, 100, 730, 489);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,350);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible 
	}

	public void disableLogInController()
	{
		f.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print(e.getActionCommand());
		if(e.getActionCommand().equalsIgnoreCase("Clear"))
		{
			userName.setText(null);
			password.setText(null);
		}
		else
		{
			System.out.println("UserName :: "+userName.getText()+" pass :: "+password.getText());
			UserDto userDto = new UserDto();
			userDto.setUserName(userName.getText());
			userDto.setPassword(password.getText());
			
			String msg = logInController.validateUserAndPassword(userDto);
			
			if(msg.equalsIgnoreCase("Success"))
			{
				System.out.println(msg);
				Order order = new Order();
				order.prepareAndOpenFrame();
				this.disableLogInController();
			}
			
			
		}
		
	}
	
	 
}

