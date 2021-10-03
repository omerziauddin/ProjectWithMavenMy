package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		//make sessionfactory  factory
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
        //creating question object 1
		Question q1=new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java?");
		
		
		
		
		Answer answer=new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is programming language");
		answer.setQuestion(q1);
		
		q1.setAnswer(answer);
		
		
				
		//creating question object 1
				Question q2=new Question();
				q2.setQuestionId(242);
				q2.setQuestion("What is collection?");
				
				
				
				
				Answer answer1=new Answer();
				answer1.setAnswerId(344);
				answer1.setAnswer("collection is an API");
				answer1.setQuestion(q2);
				
				q2.setAnswer(answer1);	
		//to save we need session as session have save method
		
		Session s=factory.openSession();
		
		//start transaction
		
		Transaction tx=s.beginTransaction();
		
		
		s.save(q1);
		s.save(answer);// WARNING DANGEROUS compulsary save this entity answer else
		//EXCEPTION : Cannot add or update a child row: a foreign key constraint fails 
		
		
		s.save(q2);
		s.save(answer1);
		//commit tx
		
		tx.commit();
		
		
		
		s.close();
		factory.close();
	}

}
