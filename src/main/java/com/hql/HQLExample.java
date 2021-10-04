package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLExample {
public static void main(String[] args) {
	
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	
	 //HQL
	//Syntax
	
	//A-->String query="from Student where city=:x ";
	String query="from Student as s where s.city=: x and s.name=: n";
	
	
	
	Session s=factory.openSession();
	
	Query q=s.createQuery(query);//now query went into Query object q
	
	//A-->q.setParameter("x", "Lucknow");//same result but dynamic value
	q.setParameter("x", "Lucknow");
	q.setParameter("n", "Peter");
	
	List<Student> list=q.list();
	
	for(Student student : list)
	{
		System.out.println(student.getName()+" course= "+student.getCerti().getCourse());
	}
	
	s.clear();
	factory.close();
}
}
