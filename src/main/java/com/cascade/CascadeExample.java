package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		//create sessionfactory
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		//create Session from factory openSession method as Session contains methods to save in db
		
		Session s=factory.openSession();
		
		//Question  1
		Question q1=new Question();
		
		//storing details of q1
		q1.setQuestionId(5625);
		q1.setQuestion("What is swing framework");
		
		//set answers of q1 so making answers then making list then saving those answers in q1
		
		//making 3 answers 
		//Answer1
		
		Answer a1=new Answer(23423,"used for develop",q1);
		Answer a2=new Answer(255,"desktop swing",q1);
		Answer a3=new Answer(35,"learn program swing",q1);
		
		//making list of 3 answers for q1
		List<Answer> list=new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		//setting answers of q1
		q1.setAnswers(list);
		
		//saving q1 to db since permanent change hence start a transaction first
		Transaction tx=s.beginTransaction();
		
		s.save(q1);    //without cascading q1 will b saved but since it has answers belonging to
		               //different table those will not b saved as we hv not told entity
		               //Question to save answers also when v save Question or we hv to manually save answers 
		               //like s.save(a1),  and so on 
		
//since using cascading no need to save answers explicitly		
//		
//		s.save(a1);
//		s.save(a2);
//		s.save(a3);
//		
		//commiting tx		
		
		tx.commit(); 
		s.close();
		factory.close();

	}

}
