package com.ats.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Manager implements Serializable {
private int id;
private String name;
private String manager_email_id;
private String phone;
private String manager_password;
String department;
int team_size;



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
public String getmanager_email_id() {
	return manager_email_id;
}
public void setmanager_email_id(String manager_email_id) {
	this.manager_email_id = manager_email_id;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getmanager_password() {
	return manager_password;
}
public void setmanager_password(String manager_password) {
	this.manager_password = manager_password;
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
public Manager(int id, String name, String manager_email_id, String phone, String manager_password, String department, int team_size) {
	super();
	this.id = id;
	this.name = name;
	this.manager_email_id = manager_email_id;
	this.phone = phone;
	this.manager_password = manager_password;
	this.department = department;
	this.team_size = team_size;
}
public Manager() {
	super();
	// TODO Auto-generated constructor stub
}

}
