package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {

	public static void main(String[] args) {
		//create Session directly from SessionFactory openSession method
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		
       
		 //Session has method createCriteria(Persistant class) which we hve to use which return a Criteria
		
		Criteria c=s.createCriteria(Student.class);
		//before fetching all data we can add restriction on c restriction matlab filter karsakte ho
		
		
		//suppose we only want list of those students jin hone sirf android ka course kiya ho 
		//now adding restrictions on c
		
		//Restrictions class has many static methods it contains all methods to filter data 
		//how to call static method ? classname.methodname
		
		c.add(Restrictions.eq("certi.course", "Android"));// equal course -->android
		
//		if taking this then error  org.hibernate.QueryException: 
//			could not resolve property: course of: com.tut.Student as course column is inside 
		//certi variable of student in certificate class
//		c.add(Restrictions.eq("course", "Android"));// equal course -->android
		
		
				
		List<Student> student=c.list();//i want all data of student 
		                         //if i dont want any restriction i want all data of Student then use this
		for(Student st : student)
		{
			System.out.println(st);
		}
		System.out.println("==========================================");
		//=====================================================================
		
		//second restriction 
		Criteria c2=s.createCriteria(Student.class);
		c2.add(Restrictions.gt("id", 1241));
		
		List<Student> student2=c2.list();
		for(Student st : student2)
		{
			System.out.println(st);
		}
		System.out.println("==========================================");
		//=====================================================================
		c2.add(Restrictions.eq("certi.course", "Android"));
		List<Student> student3=c2.list();
		//--->Restrictions--->lt,isNUll,NotNulletc
	
		for(Student st : student3)
		{
			System.out.println(st);
		}
		
		System.out.println("==========================================");
		
		
		
		Criteria c3=s.createCriteria(Student.class);
		
		c3.add(Restrictions.isNotNull("certi.duration"));
		
		c3.add(Restrictions.like("certi.course","And%" ));
       // c3.add(Restrictions.in(null, student3));
		List<Student> student4=c3.list();
		
		for(Student st : student4)
		{
			System.out.println(st);
		}
		
		
		
		s.close();
		
		//if we r adding restriction on criteria then we can do that like above
		
		
	}

}
