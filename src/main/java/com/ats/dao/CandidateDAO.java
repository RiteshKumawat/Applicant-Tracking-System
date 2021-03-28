package com.ats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ListModel;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ats.ConnectionConfig;
import com.ats.pojo.Candidate;
import com.ats.pojo.Manager;
import com.ats.pojo.TempId;
@Component
public class CandidateDAO implements CandidateDAOInterface {

	@Autowired
	@Qualifier(value="connection")
	private Connection connection;
	
	
	public void addCandidate(Candidate candidate) {
System.out.println("CONNECTION : "+connection);
		try {
			connection = ConnectionConfig.getConnection();
			PreparedStatement preparedStatement =connection.prepareStatement("insert into candidate(name,email_id,phone_number,password,dob,address,education,experience) values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, candidate.getName());
			preparedStatement.setString(2, candidate.getEmail_id());
			preparedStatement.setString(3, candidate.getPhone_number());
			System.out.println("Inside Add Candidate : ");
			
			preparedStatement.setString(4, candidate.getPassword());
			preparedStatement.setString(5, candidate.getDob());
			preparedStatement.setString(6, candidate.getAddress());
			preparedStatement.setString(7, candidate.getEducation());
			preparedStatement.setInt(8, candidate.getExperience());
			int i=preparedStatement.executeUpdate();  
			System.out.println(i+" records inserted");  

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		
		
		
	}

	@Override
	public List<Candidate> getAllCandidates() {
		   List<Candidate> candidates_list = new LinkedList<>(); 
		    
			try {
				connection = ConnectionConfig.getConnection();

			 String queryCheck = "select * from candidate";
		        PreparedStatement preparedStatement = connection.prepareStatement(queryCheck);
		       
				
		        ResultSet rs = preparedStatement.executeQuery();
		        Candidate candidate;
		        SkillDAO skillDAO = new SkillDAO();
		        
		        while(rs.next())
		        {
		        	System.out.println("NAMS : "+rs.getString("name"));
		        	
		        	candidate = new Candidate();
		        	candidate.setId(rs.getInt("id"));
		        	candidate.setName(rs.getString("name"));
		        	candidate.setEmail_id(rs.getString("email_id"));
		        	candidate.setSkills(skillDAO.getAllSkills(candidate.getEmail_id()));
		        	candidate.setPhone_number(rs.getString("phone_number"));
		        	
		        	candidates_list.add(candidate);
		        }
		        System.out.println("Get Candidate List");
		       System.out.println(candidates_list);

		        System.out.println("Get Candidate List Done");
		        connection.close();
		 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		
		
		return candidates_list;
	}

	@Override
	public boolean isCandidateExisits(String email) {
		 try {
				connection = ConnectionConfig.getConnection();

		String queryCheck = "select * from candidate WHERE email_id = ?";
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
				String queryCheck = "select password from candidate WHERE email_id = ?";
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

	@Override
	public int getCandidateId(String email) {
		
		 try {
				connection = ConnectionConfig.getConnection();

			 String queryCheck = "select id from candidate WHERE email_id = ?";
		        PreparedStatement preparedStatement = connection.prepareStatement(queryCheck);
		       
					preparedStatement.setString(1, email);
				
		        ResultSet rs = preparedStatement.executeQuery();
		        if(rs.next()) return rs.getInt("id");
		        connection.close();
		 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 return 0;		
		}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public List<Manager> getManagersList(String email)
	{
	    List<Manager> managers_list = new LinkedList<>(); 
	    
		try {
			connection = ConnectionConfig.getConnection();

		 String queryCheck = "select * from candidate_manager_view where candidate_email_id = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(queryCheck);
	       
				preparedStatement.setString(1, email);
			
	        ResultSet rs = preparedStatement.executeQuery();
	        Manager manager;
	        while(rs.next())
	        {
	        	System.out.println("NAMS : "+rs.getString("name"));
	        	
	        	manager = new Manager();
	        	manager.setName(rs.getString("name"));
	        	manager.setmanager_email_id(rs.getString("manager_email_id"));
	        	manager.setPhone(rs.getString("phone_number"));
	        	manager.setDepartment(rs.getString("department"));
	        	managers_list.add(manager);
	        }
	       System.out.println(managers_list);
	        
	        connection.close();
	 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		return managers_list;		
	}
	
	
	public void add_manager_to_candidate(String email_id,List<TempId> myList)
	{
		try {
		connection = ConnectionConfig.getConnection();
		ManagerDAO managerDAO = new ManagerDAO();
		int manager_id = managerDAO.getManagerId(email_id);
		System.out.println("Managwe ID "+manager_id);
		PreparedStatement preparedStatement =connection.prepareStatement("insert into candidate_manager(candidate_id,manager_id) values(?,?)");
	
		for (TempId tempId : myList) {
			preparedStatement.setInt(1, tempId.getId());
			preparedStatement.setInt(2, manager_id);
			int isInserted = preparedStatement.executeUpdate();
			System.out.println("YEX : "+isInserted);
			
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  


		
		
	}
	
}
