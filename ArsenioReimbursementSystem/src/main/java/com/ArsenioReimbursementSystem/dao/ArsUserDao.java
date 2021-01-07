package com.ArsenioReimbursementSystem.dao;

import java.util.List;

import com.ArsenioReimbursementSystem.model.ArsUser;

public interface ArsUserDao {

	//CRUD METHODS ONLY
	
	
	
	//CREATE
	//creating user accounts is not part of MVP 
	
	
	//READ
	
	public List<ArsUser> selectAllArsUsers();
	public ArsUser selectArsUserByUserame(String username);
	
		
	//UPDATE
	
	public void updateUserPassword(ArsUser arsUser, String newPass);
	
	
	//DELETE
	
}
