package com.map;

import java.util.ArrayList;
import java.util.List;

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
//		
//        //creating question object 1
//		Question q1=new Question();
//		q1.setQuestionId(1212);
//		q1.setQuestion("What is java?");
//		
//		
//		
//		//creating answer 1
//		Answer answer=new Answer();
//		answer.setAnswerId(343);
//		answer.setAnswer("Java is programming language");
//		answer.setQuestion(q1);
//		
//		
//		//creating answer 2
//		
//		Answer answer1=new Answer();
//		answer1.setAnswerId(33);
//		answer1.setAnswer("with help of java we create softwares");
//		answer1.setQuestion(q1);
//		
//		
//		
//		//creating answer 3
//		
//				Answer answer2=new Answer();
//				answer2.setAnswerId(363);
//				answer2.setAnswer("java has diff frameworks");
//				answer2.setQuestion(q1);
//		//to save we need session as session have save method
//				
//				
//		//save all 3 answers in list
//				
//		List<Answer> list=new ArrayList<Answer>();
//		list.add(answer);
//		list.add(answer1);
//		list.add(answer2);
//		
//		q1.setAnswers(list);
//		
		Session s=factory.openSession();
		
		//start transaction
		
		Transaction tx=s.beginTransaction();
		
//		
//		//save 
//		s.save(q1);
//		
//		//Dangerous if left Error Cannot add or update a child row: a foreign key constraint fails
//		s.save(answer);
//		s.save(answer1);
//		s.save(answer2);
//		
//		
//		
		//fetch 
		
		
		 
		 
		Question q=(Question)s.get(Question.class,1212);// default is lazy loading ie 
		//System.out.println(q.getQuestionId());
		//System.out.println(q.getQuestion());
		System.out.println(q.getAnswers().size());// now answers will be loaded
//		
//		for(Answer a : q.getAnswers())
//		{
//			System.out.println(a.getAnswer());
//		}
//		
		//commit tx
		
		tx.commit();
//		
//		//fetching
//        Question newQ=(Question)s.get(Question.class, 1212);
//        System.out.println(newQ.getQuestion());
//       
//		
		s.close();
		factory.close();
	}//

}
