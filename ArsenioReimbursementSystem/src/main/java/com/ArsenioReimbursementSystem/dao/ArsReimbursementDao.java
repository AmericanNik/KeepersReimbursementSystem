package com.ArsenioReimbursementSystem.dao;

import java.util.List;

import com.ArsenioReimbursementSystem.model.ArsReimbursement;

public interface ArsReimbursementDao {

	//CREATE
	
	public void newReimbursement(Double reimbAmount, String reimbDescription, Integer reimbAuthor, Integer reimbTypeId );
	
	
	//READ
	
	public List<ArsReimbursement> selectAllReimbursements();
	
	public ArsReimbursement selectReimbursementById(Integer reimbId);
	
	public List<ArsReimbursement> selectUserReimbursements(Integer reimbId);
	
	
	//UPDATE
	public void updateReimbursementApproval(Integer reimbId,Integer newApprovalStatus);
	
	
	//DELETE
	
	
	
}
