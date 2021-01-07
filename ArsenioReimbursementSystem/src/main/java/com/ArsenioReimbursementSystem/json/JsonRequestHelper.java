package com.ArsenioReimbursementSystem.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ArsenioReimbursementSystem.model.ArsReimbursement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException, ServletException {
		
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		
		case "/ArsenioReimbursementSystem/json/user":
			ArsUserController.findUser(req,res);
			break;
		case "/ArsenioReimbursementSystem/json/findreimbursement":
			ReimbursementController.findReimbursement(req,res);
			break;
		case "/ArsenioReimbursementSystem/json/getmyreimbursements":
			ReimbursementController.getMyReimbursements(req,res);
			break;
		case "/ArsenioReimbursementSystem/json/submitreimbursement":
			ReimbursementController.submitReimbursement(req, res);
			break;
		case "/ArsenioReimbursementSystem/json/getAllReimbursements":
			ReimbursementController.getAllReimbursements(req, res);
			break;
		case"/ArsenioReimbursementSystem/json/judgeReimbursement":
			ReimbursementController.updateReimbursementStatusId(req, res);
			break;
		default:
			System.out.println("JsonRequestHelper Flag 1");
			
			ArsReimbursement badask = new ArsReimbursement();
			badask.setReimbId(null);
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(badask));
		
		}
		
		
	}

}
