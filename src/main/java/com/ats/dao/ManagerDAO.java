package com.ats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ats.ConnectionConfig;
import com.ats.pojo.Manager;

public class ManagerDAO implements ManagerDAOInterface {

	@Autowired
	@Qualifier(value="connection")
	private Connection connection;
	
	@Override
	public void addManager(Manager manager) {
		// TODO Auto-generated method stub
				
	}

	@Override
	public List<Manager> getAllCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isManagerExisits(String email) {
	
		
		 try {
				connection = ConnectionConfig.getConnection();

		String queryCheck = "select * from manager WHERE email_id = ?";
     PreparedStatement preparedStatement = connection.prepareStatement(queryCheck);
    
			preparedStatement.setString(1, email);
		
     ResultSet rs = preparedStatement.executeQuery();
     if(rs.next()) return true;
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return false;
		

			}

	@Override
	public String getPassword(String email) {
		
		 try {
				String queryCheck = "select password from manager WHERE email_id = ?";
				connection = ConnectionConfig.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(queryCheck);
		       
					preparedStatement.setString(1, email);
				
		        ResultSet rs = preparedStatement.executeQuery();
		        if(rs.next()) return rs.getString("password");
				 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 return null;
		
		
	}	
	
	
	public int getManagerId(String email)
	{
		
		 try {
				String queryCheck = "select id from manager WHERE email_id = ?";
				connection = ConnectionConfig.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(queryCheck);
		       
					preparedStatement.setString(1, email);
				
		        ResultSet rs = preparedStatement.executeQuery();
		        if(rs.next()) return rs.getInt("id");
				 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 return 0;
		
	}			
	}
