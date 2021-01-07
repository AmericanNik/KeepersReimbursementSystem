package com.ArsenioReimbursementSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardingMasterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("GET: In Forwarding Master Servlet. RequestURI: " + req.getRequestURI());
		
		req.getRequestDispatcher(RequestHelper.process(req)).forward(req,res);
		
	};

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("POST: In Forwarding Master Servlet. RequestURI: " + req.getRequestURI());
		
		req.getRequestDispatcher(RequestHelper.process(req)).forward(req,res);
	}
	
	
	
}
