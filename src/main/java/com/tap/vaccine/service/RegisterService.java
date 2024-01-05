package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.RegisterDAO;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class RegisterService {

	private RegisterDAO registerDAO;

	@Autowired
	public RegisterService(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}
	
	public boolean validateRegisterData(String userName,String password,String confirmPassword,String email,
					String mobileNumber,String gender,String dateOfBirth)
	{
		boolean flag = true;
		String usernameRegex = "^[a-zA-Z0-9]+$";
		String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		String mobNoRegex= "^[6789]\\d{9}$";
		String code="";
		if(userName=="" || userName.isBlank() || userName.isEmpty() || !userName.matches(usernameRegex)){
			flag = false;
			System.out.println("Invalid UserName");
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
		if(email=="" || email.isEmpty() || email.isBlank() || !email.contains("@gmail.com")) {
			flag = false;
			System.out.println("Invalid Email");
		}
		if(mobileNumber=="" || mobileNumber.isBlank() || mobileNumber.isEmpty() || !mobileNumber.matches(mobNoRegex)) {
			flag = false;
			System.out.println("Invalid Mobile Number");
		}
		if(gender=="" || gender.isBlank() || gender.isEmpty()){
			flag = false;
			System.out.println("Invalid Gender");
		}
		if(dateOfBirth==" " || dateOfBirth.isBlank() || dateOfBirth.isEmpty()) {
			flag = false;
			System.out.println("Invalid Date of Birth");
		}
		return flag;
	}
	public boolean validateUserName(String userName) {
		boolean flag = true;
		String usernameRegex = "^[a-zA-Z0-9]+$";
		if(userName=="" || userName.isBlank() || userName.isEmpty() || !userName.matches(usernameRegex)){
			flag = false;
			System.out.println("Invalid UserName");
		}
		return flag;
	}
	String code="";
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
	public boolean validateEmail(String email) {
		boolean flag =  true;
		if(email=="" || email.isEmpty() || email.isBlank() || !email.contains("@gmail.com")) {
			flag = false;
			System.out.println("Invalid Email");
		}
		return flag;
	}
	
	public boolean validateMobileNumber(String mobileNumber) {
		boolean flag = true;
		String mobNoRegex= "^[6789]\\d{9}$";
		if(mobileNumber=="" || mobileNumber.isBlank() || mobileNumber.isEmpty() || !mobileNumber.matches(mobNoRegex)) {
			flag = false;
			System.out.println("Invalid Mobile Number");
		}
		return flag;
	}
	public boolean validateGender(String gender) {
		boolean flag =  true;
		if(gender=="" || gender.isBlank() || gender.isEmpty()){
			flag = false;
			System.out.println("Invalid Gender");
		}
		return flag;
	}
	public boolean validateDateofBirth(String dateOfBirth) {
		boolean flag = true;
		if(dateOfBirth==" " || dateOfBirth.isBlank() || dateOfBirth.isEmpty()) {
			flag = false;
			System.out.println("Invalid Date of Birth");
		}
		return flag;
	}
	public boolean saveRegisterEntity(String userName,String password,String email,
			String mobileNumber,String gender,String dateOfBirth) throws Exception
	{
		RegisterEntity entity = new RegisterEntity(userName, password, email, mobileNumber, gender, dateOfBirth);
		return registerDAO.saveRegisterEntity(entity);
	}
	
}
