package com.ArsenioReimbursementSystem.service;

import java.util.List;
import java.util.logging.Level;

import com.ArsenioReimbursementSystem.dao.ArsReimbursementDao;
import com.ArsenioReimbursementSystem.dao.ArsReimbursementDaoImpl;
import com.ArsenioReimbursementSystem.model.ArsReimbursement;
import com.sun.istack.internal.logging.Logger;

public class ArsReimbursementServiceImpl implements ArsReimbursementService {

	//setting the logger
	
	
	private ArsReimbursementDao arsReimbDao = new ArsReimbursementDaoImpl();
	
	///Create
	
	@Override
	public void submitReimbursement(Double reimbAmount, String reimbDescription, Integer reimbAuthor,
			Integer reimbTypeId) {
		
//		loggy.setLevel(Level.INFO);
//		
//		
//		loggy.info(reimbAuthor+ " submitted a reimbursement for " + reimbAmount+". Type: " + reimbTypeId + ". Description: " + reimbDescription);
//		
		
		arsReimbDao.newReimbursement(reimbAmount, reimbDescription, reimbAuthor, reimbTypeId);
		
	}

	
	//READ
	@Override
	public List<ArsReimbursement> selectAllReimbursements() {
		List<ArsReimbursement> reimbursements = arsReimbDao.selectAllReimbursements();
		return reimbursements;
	}

	
	
	@Override
	public ArsReimbursement getReimbursementById(Integer reimbId) {
		ArsReimbursement reimbursement = arsReimbDao.selectReimbursementById(reimbId);
		
		
		
		return reimbursement;
	}
	
	@Override
	public List<ArsReimbursement> getUserReimbursements(Integer reimbId){
		
		List<ArsReimbursement> reimbursements = arsReimbDao.selectUserReimbursements(reimbId);
		
		return reimbursements;
	}

	
	//UPDATE
	@Override
	public void setReimbursementApproval(Integer reimbId, Integer newApprovalStatus) {
//		
//		loggy.setLevel(Level.INFO);
//		
//		
//		loggy.info(reimbId+ " was reviewed. Resut:  " + newApprovalStatus );
//		
		arsReimbDao.updateReimbursementApproval(reimbId, newApprovalStatus);
		
	}

	
	//DELETE
	
}
