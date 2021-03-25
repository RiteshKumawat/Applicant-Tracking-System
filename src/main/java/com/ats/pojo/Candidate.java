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
private String email_id;

@Column(name = "id")
private String phoneNumber;
@Column(name = "id")
private String password;
@Column(name = "id")
private Date dateOfBirth;
@Column(name = "id")
private String address_city;
@Column(name = "id")
private String education_degree;
@Column(name = "id")
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
public Candidate(int id, String name, String email_id, String phoneNumber, String password, Date dateOfBirth,
		String address_city, String education_degree, int experience) {
	super();
	this.id = id;
	this.name = name;
	this.email_id = email_id;
	this.phoneNumber = phoneNumber;
	this.password = password;
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
	return email_id;
}
public void setEmailID(String email_id) {
	this.email_id = email_id;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
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
