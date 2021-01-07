package com.ArsenioReimbursementSystem.service;

import java.util.List;

import com.ArsenioReimbursementSystem.model.ArsReimbursement;

public interface ArsReimbursementService {

	
	//CREATE
	
	public void submitReimbursement(Double reimbAmount, String reimbDescription, Integer reimbAuthor, Integer reimbTypeId);
	
	
	//READ
	
	public List<ArsReimbursement> selectAllReimbursements();
	
	public ArsReimbursement getReimbursementById(Integer reimbId);
	public List<ArsReimbursement> getUserReimbursements(Integer reimbId);
	
	//UPDATE
	
	public void setReimbursementApproval(Integer reimbId, Integer newApprovalStatus);
	
	
	//DELETE
	
	
	
}
