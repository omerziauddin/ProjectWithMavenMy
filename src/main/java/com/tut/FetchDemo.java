package com.tut;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main( String[] args )throws IOException
    {
		//get, load example to get data from db
		
		Configuration cfg=new  Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		//get and load methods are kept with session so we create a variable
		Session session=factory.openSession();
		
		
		//here we dont need any transaction as there is not saving of data in db only fetching is there
		//session returns object type object
		//get 106 id student
		
		Student student=(Student)session.load(Student.class, 104);  //instead of get we can use load method 
		System.out.println(student);//if we comment this line then hibernate will not file any sql query
		
		  //get address of addresid 2
		Address ad1=(Address)session.get(Address.class, 2);// this object with addressid 2 is called from db and now object is stored in session
		Address ad2=(Address)session.get(Address.class, 2);//the object is now called from session no db query by get similar of load
		  
		  
		  
		  
		  
		  
		  
		  
		  Address ad3=(Address)session.get(Address.class, 6);
		  //get op-->null load op-->object not found exception
		  
		  System.out.println(ad1.getCity()); System.out.println(ad2.getCity());
		  System.out.println(ad3);
		  
		  
		 
		Address ad4=(Address)session.load(Address.class, 1);
		Address ad5=(Address)session.load(Address.class, 1);
		System.out.println(ad4);
		System.out.println(ad5);
		
		
		
		session.close();
		factory.close();
    }
}

/* get will fire query  irrespective of object is used or not
 * but load method will not fire sql query after load method it will only return a dummy object not having values
 * and will fire query only after object is used*/
