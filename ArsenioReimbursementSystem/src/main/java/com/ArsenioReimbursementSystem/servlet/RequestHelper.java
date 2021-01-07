package com.ArsenioReimbursementSystem.servlet;

import javax.servlet.http.HttpServletRequest;

import com.ArsenioReimbursementSystem.controller.HomeController;
import com.ArsenioReimbursementSystem.controller.LoginController;

public class RequestHelper {
	
	public static String process(HttpServletRequest req) {
		
	System.out.println("In request helper");
		
		System.out.println();
		
		switch(req.getRequestURI()) {
		
		case "/ArsenioReimbursementSystem/forwarding/login":
			return LoginController.login(req);
		
		case "/ArsenioReimbursementSystem/forwarding/home":
			return HomeController.home(req);
		default:
			System.out.println("Helper Bad checkpoint");
			return "/resources/html/badlogin.html";
		}
		
		
	}
	
	
	
}
