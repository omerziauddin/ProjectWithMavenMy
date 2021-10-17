package com.criteria.kkJavaTutorials;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CriteriaQueryEntitySelectionClientTest {

	public static void main(String[] args) {

		try (Session session = new Configuration().configure().buildSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			
			
			CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);//using this buider instance 
			//we call create query telling that I want employee instance as output
			
			
			
			Root<Employee> root = criteriaQuery.from(Employee.class);//we want to select data from emlopyee
			//class root means Employee table is not related to any other table now we get root object
			
			
			criteriaQuery.select(root);//select all

			//criteriaQuery.where(builder.equal(root.get("employeeId"), 2)); specific data will be selected

			Query<Employee> query = session.createQuery(criteriaQuery);//creating Query 
			List<Employee> empList = query.list();
			empList.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}
//output 
//Hibernate: 
//    select
//        employee0_.employee_id as employee1_3_,
//        employee0_.date_of_joing as date_of_2_3_,
//        employee0_.email as email3_3_,
//        employee0_.employee_name as employee4_3_,
//        employee0_.salary as salary5_3_ 
//    from
//        employee_table employee0_
//Employee [employeeId=1, employeeName=Martin Bingel, email=martin.cs2017@gmail.com, doj=2021-10-17 16:04:19.325, salary=50000.0]
//Employee [employeeId=2, employeeName=Sean Murphy, email=sean.m2017@gmail.com, doj=2021-10-17 16:04:19.325, salary=90000.0]
