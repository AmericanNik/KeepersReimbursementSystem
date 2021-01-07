package com.ArsenioReimbursementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.ArsenioReimbursementSystem.model.ArsReimbursement;
import com.ArsenioReimbursementSystem.service.ArsReimbursementServiceImpl;
import com.sun.istack.internal.logging.Logger;

public class ArsReimbursementDaoImpl implements ArsReimbursementDao {
	
	//logging
//	final static Logger loggy = Logger.getLogger(ArsReimbursementDaoImpl.class);

	
	//sets the postgresql driver as a static block it'll run once and immediately set the correct driver.
	static {  
        try {
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Static block has failed me");
        }
    }
	
	public static String url = "jdbc:postgresql://" + System.getenv("TRAINING_DB_URL") + "/arsDB";
	public static String username = System.getenv("TRAINING_DB_USERNAME");
	public static String password = System.getenv("TRAINING_DB_PASSWORD");
	
	//NEW REIMBURSEMENTS
	@Override
	public void newReimbursement(Double reimbAmount, String reimbDescription, Integer reimbAuthor, Integer reimbTypeId) {
		
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql = "INSERT INTO ars_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) VALUES ("+reimbAmount+", CURRENT_TIMESTAMP, '"+reimbDescription +"', "+reimbAuthor+" ,0, "+reimbTypeId+")";
			
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				System.out.println("New Reimbursment Ticket ID: " + rs.getInt("reimb_id") +" Amount: $"+ rs.getDouble("reimb_amount"));
			}
			
//			loggy.setLevel(Level.INFO);
//			
//			
//			loggy.info(reimbAuthor+ " submitted a reimbursement for " + reimbAmount+". Type: " + reimbTypeId + ". Description: " + reimbDescription);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		
	}
	
	//SELECTING ALL REIMBURSEMENTS

	@Override
	public List<ArsReimbursement> selectAllReimbursements() {
		
		List<ArsReimbursement> reimbursements = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql  = "SELECT A.reimb_id, A.reimb_amount, reimb_submitted, reimb_resolved,reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id , B.user_first_name , b.user_last_name , b.user_role_id, B.user_email FROM ars_reimbursement A INNER JOIN  ars_users B ON A.reimb_author = B.ars_user_id";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursements.add(new ArsReimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getInt(6),rs.getInt(7), rs.getInt(8), rs.getInt(9),rs.getString(10),rs.getString(11), rs.getInt(12), rs.getString(13)));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return reimbursements;
	}
	
	//SELECT ALL REIMBURSEMENTS BELONGING TO SINGLE PERSON
	
	public List<ArsReimbursement> selectUserReimbursements(Integer reimbId) {
		
		List<ArsReimbursement> reimbursements = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql  = "SELECT A.reimb_id, A.reimb_amount, reimb_submitted, reimb_resolved,reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id , B.user_first_name , b.user_last_name , b.user_role_id, B.user_email FROM ars_reimbursement A INNER JOIN  ars_users B ON A.reimb_author = B.ars_user_id WHERE reimb_author ="+reimbId;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursements.add(new ArsReimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getInt(6),rs.getInt(7), rs.getInt(8), rs.getInt(9),rs.getString(10),rs.getString(11), rs.getInt(12), rs.getString(13)));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return reimbursements;
	}
	
	
	
	//SELECT REIMBURSEMENT BY ID

	@Override
	public ArsReimbursement selectReimbursementById(Integer reimbId) {
		
		ArsReimbursement reimbursement = new ArsReimbursement();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql = "SELECT A.reimb_id , B.user_first_name , b.user_last_name , b.user_role_id, A.reimb_amount, reimb_submitted, reimb_resolved ,reimb_description, reimb_author, B.user_email, reimb_resolver FROM ars_reimbursement A INNER JOIN  ars_users B ON A.reimb_author = b.ars_user_id WHERE reimb_id ="+reimbId;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				reimbursement.setReimbId(rs.getInt(1));
				reimbursement.setAuthorFirstName(rs.getString(2));
				reimbursement.setAuthorLastName(rs.getString(3));
				reimbursement.setAuthorRoleId(rs.getInt(4));
				reimbursement.setReimbAmount(rs.getDouble(5));
				reimbursement.setReimbSubmitted(rs.getTimestamp(6));
				reimbursement.setReimbResolved(rs.getTimestamp(7));
				reimbursement.setReimbDescription(rs.getString(8));
				reimbursement.setReimbAuthor(rs.getInt(9));
				reimbursement.setAuthorEmail(rs.getString(10));
				reimbursement.setReimbResolver(rs.getInt(11));
				
				
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public void updateReimbursementApproval(Integer reimbId, Integer newApprovalStatus) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql = "UPDATE ars_reimbursement SET reimb_status_id = "+newApprovalStatus+", reimb_resolved = CURRENT_TIMESTAMP WHERE reimb_id="+ reimbId;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			System.out.println("Approval Change Successful");
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
















