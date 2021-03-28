package com.ats.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
public class Skill implements Serializable{
	private int id;
	private String name;
	
	 
    
	
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
	public Skill(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
