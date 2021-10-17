package com.HibernateCriteriaWithProjections;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.tut.Student;

public class Projections_with_aggregate_functions {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);// Student is entity

		// Use groupBy and aggregate function

		ProjectionList pList = Projections.projectionList();

		pList.add(Projections.groupProperty("certi.course"));//groupBy clause
		pList.add(Projections.countDistinct("certi.course"));
		pList.add(Projections.count("name"));
		pList.add(Projections.sum("id"));
		pList.add(Projections.rowCount());

		criteria.setProjection(pList);

		List<Object[]> listObj = criteria.list();

		for (Object[] objArr : listObj) {
			System.out.println("group property    = " + objArr[0] + "\n " + "countDistinct=   " + objArr[1] + " \n"
					+ "name list    " + objArr[2] + "\n " + "sum of id  " + objArr[3] + " \n " + "rowCount    " + objArr[4]);
		}

	}
//	output
//	 select
//     this_.course as y0_,
//     count(distinct this_.course) as y1_,
//     count(this_.name) as y2_,
//     sum(this_.id) as y3_,
//     count(*) as y4_ 
// from
//     Student this_ 
// group by
//     this_.course
//group property    = android
//countDistinct=   1 
//name list    4
//sum of id  27179 
//rowCount    4
//group property    = hibernate
//countDistinct=   1 
//name list    1
//sum of id  1234 
//rowCount    1


}
