package com.ats.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager {
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
private int id;
@Column(name = "name")
private String name;
@Column(name = "email_id")
private String email_id;
@Column(name = "phone")
private String phone;
@Column(name = "password")
private String password;


@ManyToMany(mappedBy="candidate_manager_set")
private Set<Candidate> candidatesSet= new HashSet<Candidate>();


public int getId() {
	return id;
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
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public int getTeam_size() {
	return team_size;
}
public void setTeam_size(int team_size) {
	this.team_size = team_size;
}
String department;
int team_size;
public Manager(int id, String name, String email_id, String phone, String password, String department, int team_size) {
	super();
	this.id = id;
	this.name = name;
	this.email_id = email_id;
	this.phone = phone;
	this.password = password;
	this.department = department;
	this.team_size = team_size;
}
public Manager() {
	super();
	// TODO Auto-generated constructor stub
}

}
