package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLPegination {
          public static void main(String[] args)
       {
	
        	  
        	  SessionFactory factory=new Configuration().configure().buildSessionFactory();
        	  //pagination means kaha se start karna chahte ho kitne elements chahte ho jese 5 se shuru
        	  //karke 12 tak chahiye
        	  //page size matlab ek page me kitne elements nikalne hai
        	  
        	  Session s=factory.openSession();
        	  
        	  //getting Query object
        	  Query query=s.createQuery("from Student");
        	  //Query<Student> query=s.createQuery("from Student ");
        	  // Query query=s.createQuery("from Student ",Student.class);
        	  
        	  //implementing pagination using hibernate
        	  //defining page size using setFirst and setMax results of query
        	  query.setFirstResult(0);  //start of page index 0 ie pehli row
        	  query.setMaxResults(5);   //end of page deciding last row of page 
        	  
        	  List<Student> list=query.list();
        	  //List<Student> list=query.getResultList();
        	  
        	  for(Student st : list)
        	  {
        		  System.out.println(st.getId()+" :  "+st.getName()+" : "+st.getCity());
        	  }
        	  
        	  
        	  factory.close();
        	  
        	  
       }
}
