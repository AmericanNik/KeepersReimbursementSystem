package com.ArsenioReimbursementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ArsenioReimbursementSystem.model.ArsUser;

public class ArsUserDaoImpl implements ArsUserDao {
	
	//sets the postgresql driver as a static block it'll run once and immediately set the correct driver.
	static {  
        try {
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Static block has failed me");
        }
    }
	
////SETTING OUR CREDENTIALS 

	public static String url = "jdbc:postgresql://" + System.getenv("TRAINING_DB_URL") + "/arsDB";
	public static String username = System.getenv("TRAINING_DB_USERNAME");
	public static String password = System.getenv("TRAINING_DB_PASSWORD");
	
	
	/////////SELECT ALL USERS
	@Override
	public List<ArsUser> selectAllArsUsers() {
		
		
		List<ArsUser> users = new ArrayList<>();
		
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM ars_users";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(new ArsUser(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	////////SELECT BY USERNAME
	
	
	@Override
	public ArsUser selectArsUserByUserame(String arsUsername) {
		ArsUser user = new ArsUser();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql = "SELECT * FROM ars_users WHERE ars_username = '" + arsUsername+"'";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserFirstName(rs.getString(4));
				user.setUserLastName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setUserRoleId(rs.getInt(7));		
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	//////////UPDATE USER PASSWORD
	
	@Override
	public void updateUserPassword(ArsUser arsUser, String newPass) {
		
		System.out.println("pass: " +newPass + " arsUser.getUsername:" + arsUser.getUserName());
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			System.out.println("Made it here!");
			String sql = "UPDATE ars_users SET ars_password = '"+ newPass+"' WHERE ars_username = '"+arsUser.getUserName()+"'";
			
			PreparedStatement ps = conn.prepareStatement(sql);	
			
			ps.executeUpdate();
			//System.out.println(ps.toString());
			
			
			System.out.println("Password successfully updated.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	
}
