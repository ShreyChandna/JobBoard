//package com.job.board.entities;
//
//import javax.persistence.Entity;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Table(name="interested")
//public class InterestedCandidates {
//
//	@ManyToOne
//	@JsonIgnore
//	private JobDetails jobDetails;
//	
//	@ManyToOne
//	@JsonIgnore
//	private Users user;
//
//	public JobDetails getJobDetails() {
//		return jobDetails;
//	}
//
//	public void setJobDetails(JobDetails jobDetails) {
//		this.jobDetails = jobDetails;
//	}
//
//	public Users getUser() {
//		return user;
//	}
//
//	public void setUser(Users user) {
//		this.user = user;
//	}
//	
//	
//}
