package com.ArsenioReimbursementSystem.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class HomeController {

	public static String home(HttpServletRequest req) {
		return "/resources/html/home.html";
	}
	
}
