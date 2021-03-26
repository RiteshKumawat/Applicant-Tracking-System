package com.ats.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ats.pojo.Candidate;

public class CandidateDAO implements CandidateDAOInterface {


	@Override
	public void addCandidate(Candidate candidate) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
		transaction=session.beginTransaction();
		session.save(candidate);
		transaction.commit();
		}catch(Exception exception) {
		if(transaction!=null) {
		transaction.rollback(); }
		exception.printStackTrace();
		}
	}

	@Override
	public List<Candidate> getAllCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCandidateExisits(String email) {
		// TODO Auto-generated method stub
		
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
		String result = "";
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
		    String queryString = "select c.candidate_password from Candidate c where c.candidate_email_id= :email";
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
