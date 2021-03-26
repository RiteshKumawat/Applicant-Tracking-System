package com.ats.dao;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ats.pojo.Candidate;
import com.ats.pojo.Manager;
import com.ats.pojo.Skill;

public class HibernateUtil
	{
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory()
	{
	if(sessionFactory==null)
	{
	try
	{
	Configuration configuration;
	configuration=new Configuration();
	Properties settings = new Properties();
	settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	settings.put(Environment.URL, "jdbc:mysql://localhost:3306/ats_db?useSSL=false");
	settings.put(Environment.USER, "ritesh");
	settings.put(Environment.PASS, "kumawat");
	settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
	settings.put(Environment.SHOW_SQL, "true");
	settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	configuration.setProperties(settings);
	configuration.addAnnotatedClass(Candidate.class);
	configuration.addAnnotatedClass(Manager.class);
	configuration.addAnnotatedClass(Skill.class);
	ServiceRegistry serviceRegistry=new
	StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	}catch(Exception e)
	{
	e.printStackTrace();
	}
	}
	return sessionFactory;
	}
	}
