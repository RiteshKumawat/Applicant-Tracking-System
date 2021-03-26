package com.ats.testcases;

import com.ats.dao.CandidateDAO;
import com.ats.dao.CandidateDAOInterface;

public class CandidateTest {
public static void main(String[] args) {
	CandidateDAO cDao = new CandidateDAO();
	cDao.getPassword("ritesh@wipro.com");
}
}
