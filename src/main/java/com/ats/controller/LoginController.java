package com.ats.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.dao.CandidateDAO;
import com.ats.dao.ManagerDAO;
import com.ats.dao.ManagerDAOInterface;
import com.ats.pojo.Candidate;
import com.ats.pojo.Manager;
import com.ats.pojo.ServiceResponse;

@RestController
@RequestMapping("/login")
public class LoginController {
@PostMapping("/candidate")
public ServiceResponse login_candidate(Candidate candidate)
{
	System.out.println("Yaha pe Aaya"+candidate.getEmail_id());
	System.out.println("Yaha pe Aaya"+candidate.getPassword());
	
	CandidateDAO candidateDAO  = new CandidateDAO();
	boolean result =  candidateDAO.isCandidateExisits(candidate.getEmail_id());
	System.err.println("BOLEN RES : "+result);
	ServiceResponse serviceResponse = new ServiceResponse();
	if(result == false)
	{
		serviceResponse.success = false;
		serviceResponse.isException = false;
		serviceResponse.exception = "No Records Found";
		return serviceResponse;
	}
	String db_password  = candidateDAO.getPassword(candidate.getEmail_id());
	System.out.println("DB PSDD : "+db_password);
	if(!db_password.equals(candidate.getPassword()))
	{
		serviceResponse.success = false;
		serviceResponse.isException = false;
		serviceResponse.exception = "Username or password is wrong";
		return serviceResponse;
	}
	
	System.out.println("CREDinatial is Correct");
	return serviceResponse;
}




@PostMapping("/manager")
public ServiceResponse login_manager(Manager manager)
{
	
	ManagerDAO managerDAO  = new ManagerDAO();
	boolean result =  managerDAO.isManagerExisits(manager.getmanager_email_id());
	ServiceResponse serviceResponse = new ServiceResponse();
	if(result == false)
	{
		serviceResponse.success = false;
		serviceResponse.isException = false;
		serviceResponse.exception = "No Records Found";
		return serviceResponse;
	}
	String db_password  = managerDAO.getPassword(manager.getmanager_email_id());
	if(!db_password.equals(manager.getmanager_password()))
	{
		serviceResponse.success = false;
		serviceResponse.isException = false;
		serviceResponse.exception = "Username or password is wrong";
		return serviceResponse;
	}
	return serviceResponse;
}




@GetMapping("/test")
public ServiceResponse testing()
{
	System.out.println("DCCCCCCCCCCCCCJSSSSSSSSSSSSSSSSSVSCEQEone : ");
	return new ServiceResponse();
}

}