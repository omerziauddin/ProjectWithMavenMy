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
			
			
			
			CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);//using this buider instance 
			//we call create query telling that I want String instance as output
			
			
			
			Root<Employee> root = criteriaQuery.from(Employee.class);//we want to select data from emlopyee
			//class root means Employee table is not related to any other table now we get root object
			
			
			criteriaQuery.select(root.get("employeeName"));//select only all employee names from db

			//criteriaQuery.where(builder.equal(root.get("employeeId"), 2)); specific data will be selected

			Query<String> createQuery = session.createQuery(criteriaQuery);//creating Query 
			List<String> empName = createQuery.getResultList();
			empName.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
//	output
//	Hibernate: 
//	    select
//	        employee0_.employee_name as col_0_0_    -->> employee0_ is alias name to employye table col_0_0_ is alias of
//                                                     column name employee_name
//	    from
//	        employee_table employee0_
//	Martin Bingel
//	Sean Murphy


}
