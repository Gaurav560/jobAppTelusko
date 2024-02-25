package com.telusko.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telusko.model.JobPost;
import com.telusko.repo.JobRepo;

@Service
public class JobService {
	
	@Autowired
	private JobRepo jobRepo;
	

	
	//secured
	//adding a new job
	public JobPost addJob(JobPost jobPost) {
	return jobRepo.save(jobPost);
		
	}
	
	//secured
	//getting all jobs
	public List<JobPost> getAllJobs(){
		return jobRepo.findAll();
	}
	
	//secured
	//getting a job by id
	public JobPost getJob(int id) {
		return jobRepo.findById(id).get();
		}
	
	//secured
	//deleting a job by id
	public String deleteJob(int id) {
		jobRepo.deleteById(id);
		return "deleted successfully";
	}
	
	 public JobPost updateJob(int id, JobPost jobPostDetails) {
	        // Check if the job exists
	        JobPost existingJobPost = jobRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Job not found for this id :: " + id));
	        
	        // Update job details
	        existingJobPost.setPostProfile(jobPostDetails.getPostProfile());
	        existingJobPost.setPostDesc(jobPostDetails.getPostDesc());
	        existingJobPost.setReqExperience(jobPostDetails.getReqExperience());
	        existingJobPost.setPostTechStack(jobPostDetails.getPostTechStack()); 
	        
	        // Save the updated job back to the repository
	        final JobPost updatedJobPost = jobRepo.save(existingJobPost);
	        return updatedJobPost;
	    }
	
	
}
