package com.ats;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionConfig {
	@Bean(value = "connection")
	public static Connection getConnection()
	{
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ats_db","ritesh","kumawat");  
	System.out.println("Connection Created "+connection);   
	}catch(Exception e){ 
		System.out.println("Some error in Connection");
		System.out.println(e);
	}
		System.out.println(connection);

		return connection; 
	}
 
}
