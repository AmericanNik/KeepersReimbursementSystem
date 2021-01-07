package com.ArsenioReimbursementSystem.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ArsenioReimbursementSystem.model.ArsReimbursement;
import com.ArsenioReimbursementSystem.model.ArsUser;
import com.ArsenioReimbursementSystem.service.ArsReimbursementService;
import com.ArsenioReimbursementSystem.service.ArsReimbursementServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementController {

	public static void findReimbursement(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		System.out.println("--Flag: 5");
		ArsReimbursementService arsUserServ = new ArsReimbursementServiceImpl();

		/*
		 * This is where you'd go to the database to get the objects to send to the client
		 * This will call your service layer
		 */
		System.out.println(req.getParameter("reimbId"));
		
		try {
			System.out.println("--Flag: 6");
			Integer reimbId = Integer.parseInt(req.getParameter("reimbId"));
			ArsReimbursement reimbursement = arsUserServ.getReimbursementById(reimbId) ;
			System.out.println("-----------");
			System.out.println(reimbursement);
			res.getWriter().write(new ObjectMapper().writeValueAsString(reimbursement));
			
		} catch (Exception e) {
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(null));
			// TODO: handle exception
		}
		
		
			
		
//		if(reimbId != null) {
			
//		}else {
//			req.getDispatcherType()
//			System.out.println("Error ReimbController Flag 3");
//		}
		
	}
	
	public static void submitReimbursement(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
		ArsReimbursementService arsUserServ= new ArsReimbursementServiceImpl();
		HttpSession ses = req.getSession();
		ArsUser loggedInUser = (ArsUser) ses.getAttribute("loggedInUser");
		
		ObjectMapper mapper = new ObjectMapper();
		ArsReimbursement newReimbursement = mapper.readValue(req.getInputStream(), ArsReimbursement.class);
		System.out.println(newReimbursement);
		
		
		
//		Double reimbAmount = Double.parseDouble(req.getParameter("reimbAmount"));
//		String reimbDescription = req.getParameter("reimbDescription");
//		Integer reimbType = Integer.parseInt(req.getParameter("reimbType"));
		
//		System.out.println("reimbAmount: " + reimbAmount + " reimbDescription: " + reimbDescription + " reimbType: " + reimbType+ " loggedInUserId: "+ loggedInUser.getUserId() );
		arsUserServ.submitReimbursement(newReimbursement.getReimbAmount(), newReimbursement.getReimbDescription(), newReimbursement.getReimbAuthor(), newReimbursement.getReimbTypeId());
		// amount, descirption, author, typeid
		
		System.out.println("Submit Reimbursement");
		
	}

	public static void getMyReimbursements(HttpServletRequest req, HttpServletResponse res) throws ServletException, JsonProcessingException, IOException {
		
		System.out.println("Getting my reimbursements");
		ArsReimbursementService arsReimbServ= new ArsReimbursementServiceImpl();
		
		HttpSession ses = req.getSession(false);
		
		try {
			ArsUser loggedInUser = (ArsUser) ses.getAttribute("loggedInUser");
			
			//Integer reimbId = Integer.parseInt(req.getParameter("reimbId"));
			
			List<ArsReimbursement> reimbursements = arsReimbServ.getUserReimbursements(loggedInUser.getUserId());

			System.out.println(reimbursements);
			res.getWriter().write(new ObjectMapper().writeValueAsString(reimbursements));
			
		} catch (Exception e) {
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(null));
			// TODO: handle exception
		}
		
		
		
		
	}
	
	/////////Get all reimbursements 
	public static void getAllReimbursements(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, JsonProcessingException{
		
		System.out.println("Getting all reimbursements");
		ArsReimbursementService arsReimbServ= new ArsReimbursementServiceImpl();
		
		HttpSession ses = req.getSession(false);
		
		try {
			ArsUser loggedInUser = (ArsUser) ses.getAttribute("loggedInUser");
			
			if(loggedInUser.getUserRoleId()==0) {
						
				List<ArsReimbursement> reimbursements = arsReimbServ.selectAllReimbursements();
				res.getWriter().write(new ObjectMapper().writeValueAsString(reimbursements));
				
			}else {
				res.getWriter().write(new ObjectMapper().writeValueAsString(null));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateReimbursementStatusId(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, JsonProcessingException{
		
		System.out.println("Updating a reimbursement");
		System.out.println(req.getRequestURI());
		ArsReimbursementService arsReimbServ= new ArsReimbursementServiceImpl();
		HttpSession ses = req.getSession(false);
		
		res.setContentType("application/json");
		
		try {

			ArsUser loggedInUser = (ArsUser) ses.getAttribute("loggedInUser");
			if(loggedInUser.getUserRoleId()==0) {
				
				ObjectMapper mapper = new ObjectMapper();
				ArsReimbursement reimbJudgement = mapper.readValue(req.getInputStream(), ArsReimbursement.class);
				System.out.println(reimbJudgement);

				arsReimbServ.setReimbursementApproval(reimbJudgement.getReimbId(), reimbJudgement.getReimbStatusId());;
				res.getWriter().write(new ObjectMapper().writeValueAsString(null));
				
			}else {
				res.getWriter().write(new ObjectMapper().writeValueAsString(null));
			}
			
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(null));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}


























