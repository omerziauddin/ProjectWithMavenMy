package com.criteria.kkJavaTutorials;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CriteriaQueryEntityAttributesVideo3Morethan1Attributes {

	public static void main(String[] args) {

		try (Session session = new Configuration().configure().buildSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();//getting builder object
			
			//here we want to select more than one properties		
		   CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);//bs we r goinh to select more than one 
		   //property  it will return object array of criteriaQuery
		   //we want object[] as output for this criteriaQuery
		   
		   
			Root<Employee> root = criteriaQuery.from(Employee.class);//root enttity is employee itself			
			//criteriaQuery has a method from that specifies the root entity
			
			
			//telling root that what are the attributes which we want to select
			//properties which we want to select by get method
			Path<Object> employeeNamePath = root.get("employeeName");
			Path<Object> emailPath = root.get("email");
			Path<Object> salaryPath = root.get("salary");
			
			
			//criteriaQuery.select(builder.array(employeeNamePath,emailPath,salaryPath));
			
			//criteriaQuery is having a select method 
			//same work with instead of using array method of criteria builder we can selec
			//multiselect method of criteriaQuery
			criteriaQuery.multiselect(employeeNamePath,emailPath,salaryPath);
			
			//we r passing the CriteriaQuery which we hv build above
			Query<Object[]> query = session.createQuery(criteriaQuery);
			
			
			
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				System.out.println("Employee Name:"+(String)objects[0]);
				System.out.println("Email:"+(String)objects[1]);
				System.out.println("Salary:"+(Double)objects[2]);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
	}

}
//output
//Hibernate: 
//    select
//        employee0_.employee_name as col_0_0_,
//        employee0_.email as col_1_0_,
//        employee0_.salary as col_2_0_ 
//    from
//        employee_table employee0_
//Employee Name:Martin Bingel
//Email:martin.cs2017@gmail.com
//Salary:50000.0
//Employee Name:Sean Murphy
//Email:sean.m2017@gmail.com
//Salary:90000.0
