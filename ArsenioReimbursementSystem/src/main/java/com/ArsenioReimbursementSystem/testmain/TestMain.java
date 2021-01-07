package com.ArsenioReimbursementSystem.testmain;

import java.util.List;

import com.ArsenioReimbursementSystem.model.ArsReimbursement;
import com.ArsenioReimbursementSystem.service.ArsReimbursementService;
import com.ArsenioReimbursementSystem.service.ArsReimbursementServiceImpl;

public class TestMain {

	
	public static void main(String[] args) {
		//users service
		//ArsUserService arsServ = new ArsUserServiceImpl();
		
		//reimbursement service
		ArsReimbursementService arsReimbServ = new ArsReimbursementServiceImpl();
		
		
		//Sets reimbursement approval
		//arsReimbServ.setReimbursementApproval(5, 1);
		
		
		//Gets a single reimbursement by ID
	//	ArsReimbursement reimbursement = arsReimbServ.getReimbursementById(5);
	//	System.out.println(reimbursement);
		
		//Select All reimbursements
		List<ArsReimbursement> reimbursements = arsReimbServ.selectAllReimbursements();
		
		for(ArsReimbursement r: reimbursements) {
			System.out.println(r);
		}
		
		
		//create a new reimbursement
		//arsReimbServ.submitReimbursement(5002.23, "5k down", 4, 2);
		
		//ArsUser user = arsServ.getArsUserByUsername("Hawkeye21");
		
		
		
		//Change user password
		//ArsUser user1 = new ArsUser();
		//user1.setUserName("Hawkeye21");
		//arsServ.newUserPassword(user1, "pass");
		
		//System.out.println(user);
		
		
		///Getting all users
//		List<ArsUser> users = arsServ.getAllArsUsers();
//		for(ArsUser u: users) {
//			System.out.println(u);
//		}
		
	}
	
}
