package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.ForgotPasswordService;

@Controller
public class ForgotPasswordController {
	
	private ForgotPasswordService forgotPasswordService;
	
	@Autowired
	public ForgotPasswordController(ForgotPasswordService forgotPasswordService) {
		this.forgotPasswordService = forgotPasswordService;
	}

	@RequestMapping(value="/getForgotPasswordPage")
	public String getForgotPasswordPage()
	{
		return "WEB-INF/forgotPassword.jsp";
	}
	
	@RequestMapping(value="/getForgotPasswordData")
	public String getForgotPasswordDataRequestHandler(@RequestParam String email, @RequestParam String password,
													@RequestParam String confirmPassword, Model model) throws Exception
	{
		System.out.println("Invoked getForgotPasswordDataRequestHandler()..");
		if(!forgotPasswordService.validateEmail(email)) {
			model.addAttribute("email", "enter a valid email");
		}
		if(!forgotPasswordService.validatePassword(password)) {
			model.addAttribute("password1","-> minimum length of 8 characters");
			model.addAttribute("password2","-> should have at least one uppercase letter");
			model.addAttribute("password3","-> should have at least one lowercase letter");
			model.addAttribute("password4","-> should have at least one digit");
			model.addAttribute("password5","-> should have at least one special character");
		}
		if(!forgotPasswordService.validateConfirmPassword(confirmPassword)) {
			model.addAttribute("confirmPassword", "passwords does not match");
		}
		if(forgotPasswordService.validateForgotPasswordData(email, password, confirmPassword))
		{
			if(forgotPasswordService.resetPasswordByEmail(email,password)) {
				model.addAttribute("yes", "Password changed successfully");
			}else {
				model.addAttribute("no", "Something went wrong");
			}
		}else {
			model.addAttribute("no", "Invalid email or password");
		}
		
		return "WEB-INF/forgotPassword.jsp";	
	}
}
