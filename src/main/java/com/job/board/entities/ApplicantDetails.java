package com.job.board.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Applicant")
public class ApplicantDetails {

	@Id
	private int ApplcantId;
	private String name;
	private int age;
	private String Qualification;
	private String workExperience;
	private String skills;
	private float cgpa;
	public int getApplcantId() {
		return ApplcantId;
	}
	public void setApplcantId(int applcantId) {
		ApplcantId = applcantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public float getCgpa() {
		return cgpa;
	}
	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}
	@Override
	public String toString() {
		return "ApplicantDetails [ApplcantId=" + ApplcantId + ", name=" + name + ", age=" + age + ", Qualification="
				+ Qualification + ", workExperience=" + workExperience + ", skills=" + skills + ", cgpa=" + cgpa + "]";
	}
	
	
}
