package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class CriteriaExample {

	public static void main(String[] args) {
		//create Session directly from SessionFactory openSession method
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		
        //we could hv fired Queries with HQL createQuery or SQL createSQL methods but here we r using
		//criteria api so no need to write queries
		
		 //Session has method createCriteria(Persistant class) which we hve to use which return a Criteria
		
		Criteria c=s.createCriteria(Student.class);
		
		//hamne Session se bola ki hamara create criteria kardo and we r expecting Student ka data
		//to session created a criteria which we stored in variable c
		
		//now we can use this criteria c ko data ko filter karne k ,koi restriction lagani h wo sab laga sakte ho
		
		
		List<Student> student=c.list();//i want all data of student 
		                         //if i dont want any restriction i want all data of Student then use this
		for(Student st : student)
		{
			System.out.println(st);
		}
		
		
		
		s.close();
	}

}
