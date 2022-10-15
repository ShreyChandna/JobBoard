package com.job.board.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="users")
public class Users {
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<JobDetails> jobdetails=new ArrayList<>();
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@NotBlank(message="NAME FIELD IS REQUIRED!!")
private String name;

@Column(unique = true)
@NotBlank(message="USERNAME FIELD IS REQUIRED!!")
private String username;
public List<JobDetails> getJobdetails() {
	return jobdetails;
}
public void setJobdetails(List<JobDetails> jobdetails) {
	this.jobdetails = jobdetails;
}
@NotBlank(message="EMAIL FIELD IS REQUIRED!!")
private String Email;
@NotBlank(message="Password FIELD IS REQUIRED!!")
private String password;

private String role;


public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Users [id=" + id + ", name=" + name + ", username=" + username + ", Email=" + Email + ", password="
			+ password + "]";
}

}
