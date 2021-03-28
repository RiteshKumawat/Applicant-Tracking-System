package com.ats.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.dao.CandidateDAO;
import com.ats.pojo.*;


@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {
@GetMapping( value = "/candidate/{email_id}")
public ServiceResponse getManagersList(@PathVariable(value = "email_id")String email_id)
{
	ServiceResponse serviceResponse = new ServiceResponse();
	
	CandidateDAO candidateDAO = new CandidateDAO();
	List<Manager> managers  = candidateDAO.getManagersList(email_id);
	if(managers.size()<1)
	{
		serviceResponse.result = false;
		serviceResponse.isException = true;
		serviceResponse.exception = "Not Selected by managers";
		return serviceResponse;
	}
	serviceResponse.hasResult = true;
	serviceResponse.result = managers;
	return serviceResponse;
}

@GetMapping(value ="/candidate/get_list")
public ServiceResponse getCandidatesList()
{
	ServiceResponse serviceResponse = new ServiceResponse();
	
	CandidateDAO candidateDAO = new CandidateDAO();
	System.out.println("dAO IS : "+candidateDAO);
	List<Candidate> candidates  = candidateDAO.getAllCandidates();
	System.out.println("Candiate is : "+candidates);
	if(candidates.size()<1)
	{
		serviceResponse.result = false;
		serviceResponse.isException = true;
		serviceResponse.exception = "No Candidates";
		return serviceResponse;
	}
	serviceResponse.hasResult = true;
	serviceResponse.result = candidates;
	return serviceResponse;
}

@PostMapping("/select/{email_id}")
public ServiceResponse addStudents(@RequestBody List<TempId> myList,@PathVariable(value = "email_id")String email_id)
{
	System.out.println("Values : "+myList);
	System.out.println("Values : "+email_id);
	
	CandidateDAO candidateDAO = new CandidateDAO();

	for (TempId tempId : myList) {
		System.out.println("id : "+tempId.getId());
	}	
	
	candidateDAO.add_manager_to_candidate(email_id,myList);
	return new ServiceResponse();
}


}
