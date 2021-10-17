package com.HibernateCriteriaWithProjections;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.tut.Student;

public class Multiple_Projections {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Criteria criteria=session.createCriteria(Student.class);//Student is entity
		
		
		
		//in order to fetch Student i will use hibernate criteria and projection object
		
	
		//in order to only fetch course of Student class
	   // criteria.setProjection(Projections.property("certi.course"));
		
				
		
		//in order to fetch multiple fields of Student class use ProjectionList
		ProjectionList pList=Projections.projectionList();
		
		//now adding projections  ie the columns which we want to select
		
		pList.add(Projections.property("certi.course"));
		pList.add(Projections.property("city"));
		
		
		criteria.setProjection(pList);//it will return List of Object[] ie
		//List[0] p Object[] hoga jisme saare course honge  and List[1] p Object[] hoga jisme saare  cities honge
		
		List<Object[]> listObj=criteria.list();
		
		for(Object[] objArr : listObj)
		{
			System.out.println("course = "+objArr[0]+"  &  city = "+objArr[1]);
		}
		
		tx.commit();
		session.close();
		

	}

}
//output
//Hibernate: 
//    select
//        this_.course as y0_,
//        this_.city as y1_ 
//    from
//        Student this_
//course = hibernate  &  city = Delhi
//course = android  &  city = lucknow
//course = android  &  city = Delhi
//course = android  &  city = Delhi
//course = android  &  city = lucknow
