package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {
     
	public static void main(String[] args) 
	{
	
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();  
		
		//first level caching is associated with Session object and is by desfault available
		
		
		Student student=session.get(Student.class, 1241);
		
		System.out.println(student);
		
		
		System.out.println("working on something");
		
		Student student1=session.get(Student.class, 1241);//query will not be fired on db by hibernate it will use
		                                   //valye of this object from first level cache memory
		
		//to check if some object is there in session cache
		System.out.println(session.contains(student1));
		
		
		
		session.close();
		factory.close();
		
		 
		
		
	}
}
