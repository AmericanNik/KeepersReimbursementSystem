package com.ArsenioReimbursementSystem.model;

import java.sql.Timestamp;

public class ArsReimbursement {

	private Integer reimbId;
	private Double reimbAmount;
	private Timestamp reimbSubmitted;
	private Timestamp  reimbResolved;
	private String reimbDescription;
	private Integer reimbAuthor;
	private Integer reimbResolver;
	private Integer reimbStatusId;
	private Integer reimbTypeId;
	private String authorFirstName;
	private String authorLastName;
	private Integer authorRoleId;
	private String authorEmail;
	
	public ArsReimbursement() {
		
	}
	
	
	public ArsReimbursement(Integer reimbStatusId, Integer reimbId) {
		this.reimbStatusId=reimbStatusId;
		this.reimbId = reimbId;
	}
	
	public ArsReimbursement(Double reimbAmount, String reimbDescription, Integer reimbTypeId, Integer reimbAuthor ) {
		
		this.reimbAmount= reimbAmount;
		this.reimbDescription=reimbDescription;
		this.reimbTypeId=reimbTypeId;
		this.reimbAuthor = reimbAuthor;
		
	}

	public ArsReimbursement(Integer reimbId, String authorFirstName, String authorLastName, Integer authorRoleId,
			Double reimbAmount, Timestamp reimbSubmitted, String reimbDescription, Integer reimbAuthor) {
		super();
		this.reimbId = reimbId;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.authorRoleId = authorRoleId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
	}




	public ArsReimbursement(Integer reimbId, Double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, Integer reimbAuthor, Integer reimbResolver, Integer reimbStatusId,
			Integer reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}



	public ArsReimbursement(Integer reimbId, Double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, Integer reimbAuthor, Integer reimbResolver, Integer reimbStatusId,
			Integer reimbTypeId, String authorFirstName, String authorLastName, Integer authorRoleId,
			String authorEmail) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.authorRoleId = authorRoleId;
		this.authorEmail = authorEmail;
	}




	public Integer getReimbId() {
		return reimbId;
	}

	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}

	public Double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(Double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public Integer getAuthorRoleId() {
		return authorRoleId;
	}

	public void setAuthorRoleId(Integer authorRoleId) {
		this.authorRoleId = authorRoleId;
	}

	public Timestamp getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public Integer getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(Integer reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public Integer getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(Integer reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public Integer getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(Integer reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public Integer getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(Integer reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	@Override
	public String toString() {
		return "ArsReimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatusId="
				+ reimbStatusId + ", reimbTypeId=" + reimbTypeId + "]";
	}




	public String getAuthorEmail() {
		return authorEmail;
	}




	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	
	
	
	
}
