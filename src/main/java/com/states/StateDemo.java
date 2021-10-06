package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	
	public static void main(String[] args) {
		
		//Practical of Hibernate Object States:
		//Transient
		//Persistent 
		//Detached 
		//Removed
		System.out.println("Example :");
		//agar config file hibernate ki kahi aur h to full path name likha jayga
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		//Creating student object:
		Student student=new Student();
		student.setId(1414);
		student.setName("Peter");
		student.setCity("ABC");
		student.setCerti(new Certificate("Java Hibernate Course","2 month"));
		//student : Transient
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student);//session k pass student object 
		//ka reference ajayga aur object session se associate ho jayag aur kyoki
		
		//student: Persistent - session,database
		student.setName("John");//kyoki persistant state me h isliye db me john save hoa nake peter
		
		tx.commit();
		
		s.close();
		//student : Detached:
		student.setName("Sachin");//this value will not be stored in db but will only come in below sop 
		
		System.out.println(student);
		f.close();
	}

}

// Constraint voilation exception comes due to pk present in table first dlt that then rerun program solved




