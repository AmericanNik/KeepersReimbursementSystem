package com.ArsenioReimbursementSystem.service;

import java.util.List;

import com.ArsenioReimbursementSystem.model.ArsUser;

public interface ArsUserService {

	//Create
	
	//READ
	
	
	public List<ArsUser> getAllArsUsers();
	public ArsUser getArsUserByUsername(String username);
	
	
	//UPDATE
	
	public void newUserPassword(ArsUser arsUser, String newPass);
	
	
	//DELETE
	
}
