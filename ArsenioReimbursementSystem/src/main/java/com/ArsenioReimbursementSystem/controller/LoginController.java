package com.ArsenioReimbursementSystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ArsenioReimbursementSystem.model.ArsUser;
import com.ArsenioReimbursementSystem.service.ArsUserService;
import com.ArsenioReimbursementSystem.service.ArsUserServiceImpl;

public class LoginController {

	public static String login(HttpServletRequest req) {
		
		ArsUserService userServ = new ArsUserServiceImpl();
		
		
		System.out.println("In login controller!!");
		
		/*
		 * employ route guarding here.
		 * 
		 * check if user has admin token in their sessions
		 * 
		 * check if they're using the correct http method
		 * 
		 */
		
		if(!req.getMethod().equals("POST")) {
			System.out.println("Sent home for not being a post");
			return "index.html";
		}
		
		//getting user by username
		ArsUser  loginAttemptUser = userServ.getArsUserByUsername(req.getParameter("username"));
		
		if(loginAttemptUser.getUserName() == null) {
			return "/forwarding/invalidcredentials";
		}
		
		//extracting form data		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
//				
//		
//		System.out.println(req.getParameter("username"));
//		System.out.println(req.getParameter("password"));		
//		System.out.println(loginAttemptUser.getUserName());
//		System.out.println(loginAttemptUser.getUserPassword());
		
		//Check to see if the user has the correct username and password
		if(!(username.contentEquals(loginAttemptUser.getUserName()) & password.contentEquals(loginAttemptUser.getUserPassword()))) {
			System.out.println("Sent home for invalid credentials");
			return "/forwarding/invalidcredentials";
		} else {
			
			//puts logged in user's information inside of the session.
			loginAttemptUser.setUserPassword(null);
			HttpSession session = req.getSession();
			session.setAttribute("loggedInUser", loginAttemptUser);
			
//			req.getSession().setAttribute("loggedusername", username);
//			req.getSession().setAttribute("loggedPassword", password);
			
			return "/forwarding/home";
		}
		
		
		
	}
	
	
}
