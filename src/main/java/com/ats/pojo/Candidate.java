package com.ats.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
private int id;

@Column(name = "name")
private String name;

@Column(name = "email_id")
private String candidate_email_id;

@Column(name = "phone_number")
private String phoneNumber;
@Column(name = "password")
private String candidate_password;
@Column(name = "dob")
private Date dateOfBirth;
@Column(name = "address")
private String address_city;
@Column(name = "education")
private String education_degree;
@Column(name = "experience")
private int experience;

@ManyToMany(cascade = { CascadeType.ALL })
@JoinTable(
    name = "Candidate_Skill", 
    joinColumns = { @JoinColumn(name = "candidate_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "skill_id") }
)
Set<Skill> candidate_skill_set = new HashSet<>();

@ManyToMany(cascade = { CascadeType.ALL })
@JoinTable(
    name = "Candidate_Manager", 
    joinColumns = { @JoinColumn(name = "candidate_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "manager_id") }
)
Set<Manager> candidate_manager_set = new HashSet<>();




public int getId() {
	return id;
}
public Candidate() {
	super();
	// TODO Auto-generated constructor stub
}
public Candidate(int id, String name, String candidate_email_id, String phoneNumber, String candidate_password, Date dateOfBirth,
		String address_city, String education_degree, int experience) {
	super();
	this.id = id;
	this.name = name;
	this.candidate_email_id = candidate_email_id;
	this.phoneNumber = phoneNumber;
	this.candidate_password = candidate_password;
	this.dateOfBirth = dateOfBirth;
	this.address_city = address_city;
	this.education_degree = education_degree;
	this.experience = experience;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailID() {
	return candidate_email_id;
}
public void setEmailID(String candidate_email_id) {
	this.candidate_email_id = candidate_email_id;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getcandidate_password() {
	return candidate_password;
}
public void setcandidate_password(String candidate_password) {
	this.candidate_password = candidate_password;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getAddress_city() {
	return address_city;
}
public void setAddress_city(String address_city) {
	this.address_city = address_city;
}
public String getEducation_degree() {
	return education_degree;
}
public void setEducation_degree(String education_degree) {
	this.education_degree = education_degree;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}

public Set<Skill> getCandidate_skill_set() {
	return candidate_skill_set;
}
public void setCandidate_skill_set(Set<Skill> candidate_skill_set) {
	this.candidate_skill_set = candidate_skill_set;
}
public Set<Manager> getCandidate_manager_set() {
	return candidate_manager_set;
}
public void setCandidate_manager_set(Set<Manager> candidate_manager_set) {
	this.candidate_manager_set = candidate_manager_set;
}

}
