package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import com.tut.Student;

public class CriteriaWithExampleObject {

	public static void main(String[] args)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		Student student=new Student();
		//student.setId(1234);
		student.setName("peter");
		student.setCity("Delhi");
		
		//hibernate dont consider setting up of primary key and null values in example object
		
		Example example=Example.create(student);
		
		Criteria criteria=session.createCriteria(Student.class)
				                 .add(example);
		
		
		List<Student> studentList=criteria.list();
		for(Student student2 : studentList)
		{
			System.out.println(student2);
		}
		
		session.getTransaction().commit();
		session.close();
	}
}

//output
//select
//this_.id as id1_6_0_,
//this_.course as course2_6_0_,
//this_.duration as duration3_6_0_,
//this_.city as city4_6_0_,
//this_.name as name5_6_0_ 
//from
//Student this_ 
//where
//(
//    this_.city=? 
//    and this_.name=?
//)
//Student [id=1234, name=peter, city=Delhi]
