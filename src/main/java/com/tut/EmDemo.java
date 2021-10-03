package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main( String[] args )
    {
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        //Student1 details
        Student student1=new Student();
        student1.setId(14134);
        student1.setName("Ankit Tiwari");
        student1.setCity("lucknow");        
        
        Certificate certificate=new Certificate();
        certificate.setCourse("Android");
        certificate.setDuration("2 months");        
        
        student1.setCerti(certificate);  
        
        //Student 2
        Student student2=new Student();
        student2.setId(1212);
        student2.setName("Ravi");
        student2.setCity("delhi");        
        
        Certificate certificate1=new Certificate();
        certificate1.setCourse("hibernate");
        certificate1.setDuration("1 months"); 
        
        
        student2.setCerti(certificate1);
        
        //save data in db
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
        
        s.save(student1);
        s.save(student2);
        
        tx.commit();
        
        
        
        s.close();
        factory.close();
		
    }
}
