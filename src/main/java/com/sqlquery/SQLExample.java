package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SQLExample {

	public static void main(String[] args) {
		//making session factory
		//agar config file hibernate ki kahi aur h to full path name likha jayga
	   SessionFactory factory=new Configuration().configure().buildSessionFactory();
	   
	   //factory se banayge session factory k pass ek method h opene session jo mujhe ek session de dega
	   
	   
	   Session s=factory.openSession();
	   
	   //now we want SQL Query
	   String q="Select * from student";
	   NativeQuery nq = s.createSQLQuery(q); //ctr+1  nq is interface that reprsent interface native query
	   
	   //Query nq = s.createSQLQuery(q);  can also be used
	   
	   
	   //getting data
	   //hamari table will be an Object[] uske andar chote chote objects hain see notes txt
	  List<Object[]> list=nq.list(); //nq.getResultList() can also be used
	  
	  for(Object[] student : list)
	  {
		  System.out.println(student[4]+" : "+student[3]);
		  
	  }
	  
	   
	   
			   
	  // s.createQuery(q);--->>>>q is HQL query		to fire HQL queries
	  //s.createSQLQuery(q);---->>>>q here is SQL query    to fire SQL queries will return native query object
	   
	   s.close();
	   factory.close();

	}

}
