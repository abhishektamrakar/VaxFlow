package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.ForgotPasswordDAO;

@Component
public class ForgotPasswordService {

	private ForgotPasswordDAO forgotPasswordDAO;
	
	@Autowired
	public ForgotPasswordService(ForgotPasswordDAO forgotPasswordDAO) {
		this.forgotPasswordDAO = forgotPasswordDAO;
	}
	
	public boolean validateForgotPasswordData(String email, String password, String confirmPassword)
	{
		boolean flag = true;
		String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		String code="";
		if(email=="" || email.isEmpty() || email.isBlank() || !email.contains("@gmail.com")) {
			flag = false;
			System.out.println("Invalid Email");
		}
		if(password=="" || password.isBlank() || password.isBlank() || !password.matches(passwordRegex)) {
			flag = false;
			System.out.println("Invalid Password");
		}
		else {
			code = password;
		}
		if(confirmPassword=="" || confirmPassword.isBlank()|| confirmPassword.isEmpty() || !code.equals(confirmPassword)) {
			flag = false;
			System.out.println("Invalid Confirm Password");
		}
		return flag;
	}
	String code="";
	public boolean validateEmail(String email) {
		boolean flag =  true;
		if(email=="" || email.isEmpty() || email.isBlank() || !email.contains("@gmail.com")) {
			flag = false;
			System.out.println("Invalid Email");
		}
		return flag;
	}
	public boolean validatePassword(String password) {
		boolean flag = true;
		String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		if(password=="" || password.isBlank() || password.isBlank() || !password.matches(passwordRegex)) {
			flag = false;
			System.out.println("Invalid Password");
		}
		else {
			code = password;
		}
		return flag;
	}
	public boolean validateConfirmPassword(String confirmPassword) {
		boolean flag =  true;
		if(confirmPassword=="" || confirmPassword.isBlank()|| confirmPassword.isEmpty() || !code.equals(confirmPassword)) {
			flag = false;
			System.out.println("Invalid Confirm Password");
		}
		return flag;
	}
	public boolean resetPasswordByEmail(String email, String password) throws Exception
	{
		return forgotPasswordDAO.resetPasswordByEmail(email, password);
	}
}
