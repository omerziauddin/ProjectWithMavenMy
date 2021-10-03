package com.tut;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
//if not providing @Embeddable then error :
//Could not determine type for: com.tut.Certificate, at table: Student,
//for columns: [org.hibernate.mapping.Column(certi)]
//embed fields of Certificate class into any other class like here student class
@Embeddable
public class Certificate {

	private String course;
	private String duration;
	
	
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Certificate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Certificate [course=" + course + ", duration=" + duration + "]";
	}
	
	
}
