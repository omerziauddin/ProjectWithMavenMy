package com.tut;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity//(name="student_details") to name table in db or use 
//@Table(name="student_details")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)//both to enable second level caching
public class Student {
    //make id as primary key
	@Id
	private int id;
	//now id is primray key of table 
	
	
	private String name;
	
	private String city;
	//to give student a certificate
	private Certificate certi;
	
	
	
	
	
	
	
	public Certificate getCerti() {
		return certi;
	}
	public void setCerti(Certificate certi) {
		this.certi = certi;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public Student() {
		super();
		
	}
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
