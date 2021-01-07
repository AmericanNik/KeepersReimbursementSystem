package com.ArsenioReimbursementSystem.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ArsenioReimbursementSystem.servlet.RequestHelper;

public class JsonMasterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("GET: In Forwarding Master Servlet. RequestURI: " + req.getRequestURI());
		
		JsonRequestHelper.process(req, res);
		
	};

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("POST: In Forwarding Master Servlet. RequestURI: " + req.getRequestURI());
		
		JsonRequestHelper.process(req,res);
	}
	
	
}
