package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
//	
//	Query q=s.createQuery(query);//now query went into Query object q
//	
//	//A-->q.setParameter("x", "Lucknow");//same result but dynamic value
//	q.setParameter("x", "Lucknow");
//	q.setParameter("n", "Peter");
//	
//	List<Student> list=q.list();
//	
//	for(Student student : list)
//	{
//		System.out.println(student.getName()+" course= "+student.getCerti().getCourse());
//	}
//	
//	
	System.out.println("-------------------------------------------------------------------");
	Transaction tx=s.beginTransaction();
	
	
//	//using alias s not necessary 
//	Delete
//	Query q2=s.createQuery("delete from Student as s where s.city=: c");
//	
//	//firing Query
//	q2.setParameter("c", "ABC");
//	int r=q2.executeUpdate();//  if not begining Transaction then  javax.persistence.TransactionRequiredException
//	
//	System.out.println("Deleted");
//	System.out.println(r);
//	
//	//update query
//	Query q2=s.createQuery("update Student set city=: c where name=: n");
//	//Student is entity class ie persistant class and city name are variables of this class
//	q2.setParameter("c","Delhi");
//	q2.setParameter("n", "Peter");
//	int r=q2.executeUpdate();
//	
//	System.out.println(r+" objects updated");
	
	
	
	//ek question se saare answer nikalna chah rahe hain not through single object but through joining
	//Question and Answer table
	
	
	//how to execute join query      
	//Question INNER JOIN Question.answer
	
	Query q3=s.createQuery("select q.question , q.questionId, a.answer from Question as q INNER JOIN q.answers as a");
	//Query q3=s.createQuery("select Question.question , Question.questionId, Answer.answer from Question INNER JOIN Question.answers");;
	
	// q=alias name for Question class
	//a=alias name for Answer class
	//above statement will join Question ( with answer as join column ) from Answer class
	//Question class ko Question class ki jo answers variable ki class h yani Answer u class se join karna h 
	
	List<Object[]> list3 =q3.getResultList();
	//Object[question,questionId,answer of this question]==>isi tara har question ki object array hogi jo saare question ki object array milke ek list banayge
	//matlab list k 0 p first Question ki details second p second and third p third Question ki details
	
	for(Object[] arr: list3)
	{
		System.out.println(Arrays.toString(arr));
	}
	
	tx.commit();
	
	s.clear();
	factory.close();
}
}
