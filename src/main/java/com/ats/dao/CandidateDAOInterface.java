package com.ats.dao;

import java.util.List;

import com.ats.pojo.Candidate;

public interface CandidateDAOInterface {
public void addCandidate(Candidate candidate);
public List<Candidate> getAllCandidates();
public boolean isCandidateExisits(String email);
public String getPassword(String email);
public int getCandidateId(String email);
}
