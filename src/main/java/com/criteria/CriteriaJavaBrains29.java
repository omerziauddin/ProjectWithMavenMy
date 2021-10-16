package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaJavaBrains29 {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		Criteria criteria=session.createCriteria(Student.class);
		
		criteria.add(Restrictions.eq("name", "peter")); //if using this then and will be added in 
		//hibernate where clause
		criteria.add(Restrictions.eq("certi.course", "android"));
		
		List<Student> studentList=criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(Student student : studentList )
		{
			System.out.println(student);
		}

	}

}
