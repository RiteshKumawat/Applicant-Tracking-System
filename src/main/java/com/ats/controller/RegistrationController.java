package com.ats.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ats.pojo.Candidate;
import com.ats.pojo.ServiceResponse;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	@PostMapping("/add")
	public ServiceResponse register_candidate(Candidate candidate,@RequestParam("resume")MultipartFile multipartFile)
	{
		ServiceResponse serviceResponse = new ServiceResponse();
		return serviceResponse;
	}
}
