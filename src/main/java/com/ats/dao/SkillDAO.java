package com.ats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.ats.ConnectionConfig;
import com.ats.pojo.Manager;

public class SkillDAO implements SkillDAOInterface {

	@Override
	public HashMap<String, Integer> getAllSkills() {
        HashMap<String, Integer>skillMap = new HashMap<>();
		 Connection connection = ConnectionConfig.getConnection();

		 try {
				String queryCheck = "select * from skill";
		        PreparedStatement preparedStatement = connection.prepareStatement(queryCheck);
		        ResultSet rs = preparedStatement.executeQuery();
		        while(rs.next())
		        {
		        	skillMap.put(rs.getString("name"), rs.getInt("id"));
		        }
		 connection.close();
		 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		 
     	return skillMap; 
	}
	
	public void add_candidate_skill_map(int candidate_id,HashSet<Integer> candidate_skill_id_set)
	{
		 try {
			 Connection connection = ConnectionConfig.getConnection();
				
		        PreparedStatement preparedStatement = connection.prepareStatement("insert into candidate_skill(candidate_id,skill_id) values(?,?)");
		       
		        for (Iterator iterator = candidate_skill_id_set.iterator(); iterator.hasNext();) {

	
				 Integer skill_id = (Integer) iterator.next();
					 
				 int id = skill_id.intValue();
				 preparedStatement.setInt(1, candidate_id);
				 preparedStatement.setInt(2, id);
				 
				 int i=preparedStatement.executeUpdate();  
				// System.out.println(i+" records inserted in skill");
				}

				 connection.close();
				 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
	
	
	public List<String> getAllSkills(String email)
	{
	    List<String> skill_List = new LinkedList<>(); 
	    
			try {
				Connection connection = ConnectionConfig.getConnection();

			 String queryCheck = "select * from candidate_skill_view where candidate_email_id = ?";
		        PreparedStatement preparedStatement = connection.prepareStatement(queryCheck);
		       
		        preparedStatement.setString(1, email);
				
		        ResultSet rs = preparedStatement.executeQuery();
		        ;
		        while(rs.next())
		        {
		        	//System.out.println("NAMS : "+rs.getString("name"));
		        	skill_List.add(rs.getString("name"));
		        }
		       System.out.println(skill_List);
		        
		        connection.close();
		 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
			return skill_List;		
		}

	}
