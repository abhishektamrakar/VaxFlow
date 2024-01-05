package com.tap.vaccine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.service.LoginService;

@Controller
public class LoginController {
	private LoginService loginService;
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(value="/getLoginPage")
	public String getLoginPage()
	{
		return "/WEB-INF/login.jsp";
	}
	
	@RequestMapping(value="/getLoginData")
	public String getLoginDataRequestHandler(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request) throws Exception
	{
		System.out.println("Invoked getLoginDataRequestHandler()");
		if(!loginService.validateEmail(email)) {
			model.addAttribute("email", "enter a valid email");
		}
		if(!loginService.validatePassword(password)) {
			model.addAttribute("password", "enter a valid password");
		}
		if(loginService.validateLoginData(email, password)) {
			RegisterEntity entity = loginService.getRegisterEntity(email);
			if(entity!=null) {
				if(loginService.verifyLoginDetails(email, password)) {
					model.addAttribute("yes", "Login Successfull..");
					HttpSession session = request.getSession(true);
					session.setAttribute("Email",email);
					if(loginService.verifyLoginDetails(email, password)) {
						model.addAttribute("memberCount",entity.getMemberCount());
						return "/WEB-INF/homePage.jsp";	
					}
					return "/WEB-INF/homePage.jsp";	
				}
				else {
					int loginAttemptCount = loginService.getRegisterEntity(email).getLoginAttempt();
					if(loginAttemptCount==3) {
						model.addAttribute("no","Your account has been blocked  &  "
								+"Click on forgot password to reset your password");
						return "/WEB-INF/login.jsp";
					}else {
					model.addAttribute("no","Email or Password is incorrect..");
					return "/WEB-INF/login.jsp";
					}
				}
			}
			else {
				model.addAttribute("no","Email or Password is incorrect..");
				return "/WEB-INF/login.jsp";
			}
		}else {
			model.addAttribute("no", "Invalid email or Inavlid password");
			return "/WEB-INF/login.jsp";
		}
	}
}
