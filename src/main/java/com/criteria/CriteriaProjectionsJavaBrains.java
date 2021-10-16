package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import com.tut.Student;

public class CriteriaProjectionsJavaBrains {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);

		criteria.setProjection(Projections.property("id"));// it will return list of Integer

		List<Integer> studentList = criteria.list();

		for (Integer student : studentList) {
			System.out.println(student);
		}

		session.getTransaction().commit();
		session.close();

	}
}
//output
//Hibernate: 
//    select
//        this_.id as y0_ 
//    from
//        Student this_
//1234
//1235
//1241
//12347
//12356
