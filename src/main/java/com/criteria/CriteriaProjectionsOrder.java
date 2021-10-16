package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import com.tut.Student;

public class CriteriaProjectionsOrder {

	public static void main(String[] args)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		Criteria criteria=session.createCriteria(Student.class);
		
		criteria.addOrder(Order.asc("id"));//  returns List of Students in ascending order of id
		
		List<Student> studentList=criteria.list();
		
		for(Student student : studentList)
		{
			System.out.println(student);
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
//output
//Hibernate: 
//    select
//        this_.id as id1_6_0_,
//        this_.course as course2_6_0_,
//        this_.duration as duration3_6_0_,
//        this_.city as city4_6_0_,
//        this_.name as name5_6_0_ 
//    from
//        Student this_ 
//    order by
//        this_.id asc
//Student [id=1234, name=peter, city=Delhi]
//Student [id=1235, name=jackson, city=lucknow]
//Student [id=1241, name=monty, city=Delhi]
//Student [id=12347, name=action, city=Delhi]
//Student [id=12356, name=anshu, city=lucknow]
