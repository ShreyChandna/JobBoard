package com.job.board.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="JobDetails")
public class JobDetails {
	
	@ManyToOne
	@JsonIgnore
	private Users user;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobid;
	private String role;
	private String description;
	private String Location;
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	private String deadline;
	private String contact;
	private long daysleft;
	public long getDaysleft() {
		return daysleft;
	}
	public void setDaysleft(long daysleft) {
		this.daysleft = daysleft;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String email;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "JobDetails [user=" + user + ", jobid=" + jobid + ", role=" + role + ", description=" + description
				+ ", Location=" + Location + ", deadline=" + deadline + ", contact=" + contact + ", email=" + email
				+ "]";
	}
	
	
	

}
