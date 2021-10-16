package com.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.tut.Student;

public class CriteriaProjectionsCount {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);

		criteria.setProjection(Projections.count("id"));

		Long countList = (Long) criteria.list().get(0);

		System.out.println("Total students are " + countList);

		session.getTransaction().commit();
		session.close();
	}
}
//output 
//Hibernate: 
//    select
//        count(this_.id) as y0_ 
//    from
//        Student this_ 
//    order by
//        this_.id desc
//Total students are 5
