package com.ArsenioReimbursementSystem.service;

import java.util.List;

import com.ArsenioReimbursementSystem.dao.ArsUserDao;
import com.ArsenioReimbursementSystem.dao.ArsUserDaoImpl;
import com.ArsenioReimbursementSystem.model.ArsUser;

public class ArsUserServiceImpl implements ArsUserService {

	private ArsUserDao arsUserDao = new ArsUserDaoImpl();

	//CREATE
	
	
	
	
	//READ

	//Getting all system users
	
	@Override
	public List<ArsUser> getAllArsUsers() {
		
		//our pre-db call business logic would go here
		List<ArsUser> userList = arsUserDao.selectAllArsUsers();		
		//our post-db call business logic would go here
		return userList;
	}
	
	@Override
	public ArsUser getArsUserByUsername(String username) {
		
		ArsUser user = arsUserDao.selectArsUserByUserame(username);
		
		return user;
	}
	
	
	
	//UPDATE
	
	@Override
	public void newUserPassword(ArsUser arsUser, String newPass) {
		arsUserDao.updateUserPassword(arsUser, newPass);
		
	}
	
	//DELETE
	
}
