package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.RegisterService;

@Controller
public class RegisterController {

	private RegisterService registerService;
	
	@Autowired
	public RegisterController(RegisterService registerService) {
		this.registerService = registerService;
	}
	
	@RequestMapping(value="/getRegisterPage")
	public String getRegisterPage()
	{
		return "/WEB-INF/register.jsp";
	}
	
	@RequestMapping(value="/getRegisterData")
	public String getRegisterDataRequestHandler(@RequestParam String userName,@RequestParam String password,
			@RequestParam String confirmPassword, @RequestParam String email, @RequestParam String mobileNumber,
			@RequestParam String gender, @RequestParam String dateOfBirth, Model model) throws Exception{
		System.out.println("Invoked getRegisterDataRequestHandler()");
		System.out.println("Gender: "+gender);
		if(!registerService.validateUserName(userName)) {
			model.addAttribute("userName","user name should contain alphabets and numbers only");
		}
		if(!registerService.validatePassword(password)) {
			model.addAttribute("password1","-> minimum length of 8 characters");
			model.addAttribute("password2","-> should have at least one uppercase letter");
			model.addAttribute("password3","-> should have at least one lowercase letter");
			model.addAttribute("password4","-> should have at least one digit");
			model.addAttribute("password5","-> should have at least one special character");
		}
		if(!registerService.validateConfirmPassword(confirmPassword)) {
			model.addAttribute("confirmPassword", "passwords does not match");
		}
		if(!registerService.validateEmail(email)) {
			model.addAttribute("email", "enter a valid email");
		}
		if(!registerService.validateMobileNumber(mobileNumber)) {
			model.addAttribute("mobileNumber", "enter a valid mobile number");
		}
		if(!registerService.validateGender(gender)) {
			model.addAttribute("gender", "select your gender");
		}
		if(!registerService.validateDateofBirth(dateOfBirth)) {
			model.addAttribute("dateOfBirth", "select your date of birth");
		}
		
		if(registerService.validateRegisterData(userName, password, confirmPassword, email, mobileNumber, gender, dateOfBirth)) {
			if(registerService.saveRegisterEntity(userName, password, email, mobileNumber, gender, dateOfBirth)) {
				model.addAttribute("yes", "Data has been saved & a Email has been sent to you..");
			}else {
				model.addAttribute("no", "Something went wrong..");
			}
		}
		else {
			model.addAttribute("no", "Invalid Data...");
		}
		return "/WEB-INF/register.jsp";	
	}
}