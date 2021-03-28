package com.ats.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ats.dao.CandidateDAO;
import com.ats.dao.SkillDAO;
import com.ats.pojo.Candidate;
import com.ats.pojo.ServiceResponse;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	@PostMapping("/add")
	public ServiceResponse register_candidate(Candidate candidate,@RequestParam("resume")MultipartFile multipartFile)
	{
		ServiceResponse serviceResponse = new ServiceResponse();
		CandidateDAO candidateDAO = new CandidateDAO();
		candidateDAO.addCandidate(candidate);
		//get Candidate id which is just inserted
		int candidate_id = candidateDAO.getCandidateId(candidate.getEmail_id());
		ResumeScanner resumeScanner = new ResumeScanner();
		resumeScanner.scan(multipartFile);
		//Skill names which is there in candidate resume 
		HashSet<String>  candidate_skill_set = resumeScanner.getSkillsSet();
		
		SkillDAO skillDAO = new SkillDAO();
		//all db skills
		HashMap<String, Integer> skillMap = skillDAO.getAllSkills();
		
		//we put id of that skills which candidate have
		HashSet<Integer> candidate_skill_id_set = new HashSet<>();
		
		for (Iterator iterator = candidate_skill_set.iterator(); iterator.hasNext();) {

			String skill_name = (String) iterator.next();
			Integer id = (Integer)skillMap.get(skill_name);
			if(id == null) continue;
			candidate_skill_id_set.add( id );
		}
		System.out.println("Size id "+candidate_skill_id_set.size());
		skillDAO.add_candidate_skill_map(candidate_id,candidate_skill_id_set);
		System.out.println("Happy ending"+serviceResponse);
		return serviceResponse;
		
	}
}
