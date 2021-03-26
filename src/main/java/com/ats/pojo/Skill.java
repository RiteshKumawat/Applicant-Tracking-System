package com.ats.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	
	 
    @ManyToMany(mappedBy="candidate_skill_set")
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
	public Skill(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Candidate> getCandidatesSet() {
		return candidatesSet;
	}
	public void setCandidatesSet(Set<Candidate> candidatesSet) {
		this.candidatesSet = candidatesSet;
	}
}
