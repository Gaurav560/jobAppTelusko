package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.JobPost;
import com.telusko.service.JobService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class JobController {
	
	@Autowired
	private JobService jobService;

	
	//controller method for getting all jobs
//	@CrossOrigin
	@GetMapping("/Jobs")
	public List<JobPost> getAllJobPosts(){
		return jobService.getAllJobs();
		
	}
	
	
	//************************************************************
	
	
	//controller method to get a Job  By Id
//	@CrossOrigin
	@GetMapping("/Job/{id}")
	public JobPost getJobPostById(@PathVariable int id) {
		return jobService.getJob(id);
	}
	
	
	
	//************************************************************
	
	
	
	
	
	//controller method to add a job 
	//@CrossOrigin
	@PostMapping("/Job")
	public JobPost addJobPost(@RequestBody JobPost jobPost) 
	{
		return jobService.addJob(jobPost);
	}
	
	
	
	
	//************************************************************
	
	
	

	
//controller method to delete a job 
	@DeleteMapping("/Job/{id}")
	//@CrossOrigin
	public String deleteJobPostById(@PathVariable int id) {
		return jobService.deleteJob(id);
		
	}
	
	
	
	 @PutMapping("/Job/{id}")
	    public JobPost updateJobPost(@PathVariable int id, @RequestBody JobPost jobPost) {
	        return jobService.updateJob(id, jobPost);
	    }
	
}