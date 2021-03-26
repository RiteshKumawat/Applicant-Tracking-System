package com.ats.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ats.pojo.Manager;

public class ManagerDAO implements ManagerDAOInterface {

	@Override
	public void addManager(Manager manager) {
		// TODO Auto-generated method stub
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
		transaction=session.beginTransaction();
		session.save(manager);
		transaction.commit();
		}catch(Exception exception) {
		if(transaction!=null) {
		transaction.rollback(); }
		exception.printStackTrace();
		}
		
	}

	@Override
	public List<Manager> getAllCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isManagerExisits(String email) {

		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
		    String queryString = "select 1 from Candidate c where c.candidate_email_id= :email";
		   Query query = session.createQuery(queryString);
		    query.setParameter("email", email);
		    Integer result = (Integer) query.uniqueResult();
		    System.out.println("Result is : "+result);
		   if(result == null) return false;

		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return true;	
	}

	@Override
	public String getPassword(String email) {
		String result="";
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
		    String queryString = "select m.manager_password from Manager m where m.manager_email_id= :email";
		   Query query = session.createQuery(queryString);
		    query.setParameter("email", email);
		    result = (String) query.uniqueResult();
		    System.out.println("Result is : "+result);
		
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	    return result;
	}	
	}
