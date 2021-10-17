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

import com.criteria.kkJavaTutorials.DTO.EmployeeDTO;

public class CriteriaQueryEntityAttributesVideo5 {

	public static void main(String[] args) {
		List<EmployeeDTO> employeesInfo = getEmployeesInfo();
		for (EmployeeDTO employeeDTO : employeesInfo) {
			System.out.println(employeeDTO.getEmployeeName()+"\t"+employeeDTO.getEmail()+"\t"+employeeDTO.getSalary());
		}
	
	}

	private static List<EmployeeDTO> getEmployeesInfo() {
		List<EmployeeDTO> resultList = null;
		try (Session session = new Configuration().configure().buildSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			
			
			
		    CriteriaQuery<EmployeeDTO> criteriaQuery = builder.createQuery(EmployeeDTO.class);
		    //telling criteriaQuery that now it will hv to return EmployeeDTO as return type
		    
		    
		    
			Root<Employee> root = criteriaQuery.from(Employee.class);
			//Employye is our root entity class
			
			
			Path<Object> employeeNamePath = root.get("employeeName");
			Path<Object> emailPath = root.get("email");
			Path<Object> salaryPath = root.get("salary");
			
			
			
			
			
			criteriaQuery.select(builder.construct(EmployeeDTO.class, employeeNamePath,emailPath,salaryPath));
			//builder construct method takes 2 parameters 1st is result class and 2 is var arg of selection
			//result class here is EmployeeDTO
			//follow same orderin in construct
			
			
			
			
			Query<EmployeeDTO> query = session.createQuery(criteriaQuery);
			
			
			//List<EmployeeDTO> list = query.list();  same result
			 resultList = query.getResultList();
		}
		
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
//output -->> DTO -->> DB

//Hibernate: 
//    select
//        employee0_.employee_name as col_0_0_,
//        employee0_.email as col_1_0_,
//        employee0_.salary as col_2_0_ 
//    from
//        employee_table employee0_
//Martin Bingel	martin.cs2017@gmail.com	50000.0
//Sean Murphy	sean.m2017@gmail.com	90000.0
