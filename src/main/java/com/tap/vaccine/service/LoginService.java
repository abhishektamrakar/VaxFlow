package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class LoginService {

	private LoginDAO loginDAO;
	private JavaMailSender javaMailSender;
	
	@Autowired
	public LoginService(LoginDAO loginDAO, JavaMailSender javaMailSender) {
		this.loginDAO = loginDAO;
		this.javaMailSender = javaMailSender;
	}
	public boolean validateLoginData(String email, String password)
	{
		boolean flag = true;
		if(email == "" || email.isBlank() || email.isEmpty() || !email.contains("@gmail.com")) {
			flag=false;
			System.out.println("Invalid Email..");
		}
		if(password==" "|| password.isBlank() || password.isBlank()) {
			flag =false;
			System.out.println("Invalid Password..");
		}
		return flag;	
	}
	public boolean validateEmail(String email)
	{
		boolean flag = true;
		if(email == "" || email.isBlank() || email.isEmpty() || !email.contains("@gmail.com")) {
			flag=false;
			System.out.println("Invalid Email..");
		}
		return flag;
	}
	public boolean validatePassword(String password)
	{
		boolean flag = true;
		if(password==" "|| password.isBlank() || password.isBlank()) {
			flag =false;
			System.out.println("Invalid Password..");
		}
		return flag;
	}
	public RegisterEntity getRegisterEntity(String email)
	{
		return loginDAO.getRegisterEntity(email);
	}
	
	public boolean verifyLoginDetails(String email, String password) throws Exception
	{
		boolean flag = true;
		final int maxAttemptCount = 3;
		RegisterEntity entity = loginDAO.getRegisterEntity(email);
		int loginAttemptCount = entity.getLoginAttempt();
		String Email = loginDAO.getRegisterEntity(email).getEmail();
		String Password = loginDAO.getRegisterEntity(email).getPassword();
		
		if(loginAttemptCount < maxAttemptCount) {
			if(!Email.equals(email)) {
				flag = false;
				System.out.println("wrong email");
			}
			if(!Password.equals(password)) {
				flag = false;
				System.out.println("wrong password");
			}
			if(!flag) {
				loginDAO.updateLoginAttemptCount(email, loginAttemptCount);
				int count = entity.getLoginAttempt();
				System.out.println("LOGIN ATTEMPT COUNT: "+ count);
				if(count==2) {
					String toMail = entity.getEmail();
					String subject = "Vaccine - Account Blocked";
					String body = "Dear "+entity.getUserName()+"\n"
							+"We're writing to inform you that your account at VACCINE has been temporarily"
							+ "locked due to multiple unsuccessful login attempts.\n"
							+"                                                    \n"
							+"Multiple unsuccessful login attempts were detected on"
							+"your account. This may be due to entering an incorrect password several times.\n"
							+"                                                    \n"
							+"To unlock your account, please follow these steps:\r\n"
							+"                                                    \n"
							+ "1. Visit our login page : http://localhost:8075/MVC-Project/getLoginPage\r\n"
							+ "2. Click on the \"Forgot Password\" link.\r\n"
							+ "3. Follow the instructions to reset your password.";
					SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
					simpleMailMessage.setTo(toMail);
					simpleMailMessage.setSubject(subject);
					simpleMailMessage.setText(body);
					
					javaMailSender.send(simpleMailMessage);
					System.out.println("Account Blocked Mail Sent...");
				}
			}
//			else {
//				loginAttemptCount =-1;
//				loginDAO.updateLoginAttemptCount(email, loginAttemptCount);
//			}
		}
		else {
			flag = false;
			System.out.println("your account has been locked");
		}
		return flag;	    
	}
}
