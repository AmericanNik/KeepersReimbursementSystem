package com.ArsenioReimbursementSystem.model;

public class ArsUser {

	private Integer userId;
	private String userName;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String email;
	private Integer userRoleId;
	
	public ArsUser() {
		
	}
	
	public ArsUser(Integer userId, String userName, String userPassword, String userFirstName, String userLastName,
			String email, Integer userRoleId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.email = email;
		this.userRoleId = userRoleId;
	}
	

	@Override
	public String toString() {
		return "ArsUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", email=" + email
				+ ", userRoleId=" + userRoleId + "]";
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getUserRoleId() {
		return userRoleId;
	}


	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}


	
	
	
	
	
	
}
