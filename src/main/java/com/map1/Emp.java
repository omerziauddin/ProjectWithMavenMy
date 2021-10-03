package com.map1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {

	@Id
	private int eid;

	private String name;

	// 1 employee can have many projects
	// not using mappedBy hence mapping will be handled by p_id column of Emp
	// which is Fk of Emp

	@ManyToMany
	@JoinTable(
			    name = "emp_learn_3rd_table", 
			    joinColumns = {@JoinColumn(name="eid")}, 
			    inverseJoinColumns = {@JoinColumn(name="pid")}
			    
			   ) // for third table that will be created
	private List<Project> projects;

	// joinColumns provide name for first column of third table ie known as
	// joinColumn
	// inverseJoinColumns provides name for second column of third table ie know as
	// inverseJoinColumn

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int eid, String name, List<Project> projects) {
		super();
		this.eid = eid;
		this.name = name;
		this.projects = projects;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
