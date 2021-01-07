package com.ArsenioReimbursementSystem.sessionservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ArsenioReimbursementSystem.model.ArsUser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SessionServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("In SessionServlet doGet");
		
		HttpSession session = req.getSession(false);
		
//		ArsUser user = (ArsUser) 
		try {
			ArsUser user = (ArsUser) session.getAttribute("loggedInUser");
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(user));
			
			System.out.println(user);
		} catch (Exception e) {
			System.out.println("outside source tried to get to homepage");
			// TODO: handle exception
		}

		

		

		
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		System.out.println("In SessionServlet doPost");
		
		HttpSession session = req.getSession(false);
		System.out.println(session);
		session.invalidate();	
		res.sendRedirect("http://localhost:9006/ArsenioReimbursementSystem/");
		
	}
	
}
