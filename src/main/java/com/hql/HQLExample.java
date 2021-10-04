package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLExample {
public static void main(String[] args) {
	//1- create sessionfactory
	//koi bhi data db se nikalne  liye through hibernate we require sessionfactory
	//create sessionfactory
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	
	 //HQL
	//Syntax
	String query="from Student";  
	//Student is entity class after firing this query hibernate will give us all object from the table student
	
	//String query="from Student where city='Lucknow' ";
	
	
	
	//2- we want session to fire query so getting session from factory
	Session s=factory.openSession();
	
	//3- s has method to fire queries so we will get object of Query
	
	Query q=s.createQuery(query);//now query went into Query object q
	
	
	//Single (unique) if we want k our query bring unique result
	//q.uniqueResult(); error if in db more than 1 result
	System.out.println(q.setMaxResults(1).uniqueResult());
	System.out.println("\n multiple results");
	
	
	//Multiple (list of objects) if we want our query to bring all objects
	List<Student> list=q.list();
	
	for(Student student : list)
	{
		System.out.println(student.getName()+" course= "+student.getCerti().getCourse());
	}
	
	s.clear();
	factory.close();
}
}
