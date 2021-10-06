package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

import net.sf.ehcache.hibernate.EhCacheRegionFactory;

public class SecondCacheExample {
	public static void main(String[] args) {
	
		//agar config file hibernate ki kahi aur h to full path name likha jayga
		//EhCacheRegionFactory import this to know location
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session1 = factory.openSession();
		// first 

		Student student1 = session1.get(Student.class, 1234);
		System.out.println(student1);

		session1.close();

		//creating new session
		
		Session session2 = factory.openSession();
		// second
		Student student2 = session2.get(Student.class, 1234);//query will not be fired by hibernate
		                  //as data is taken from second level cache
		System.out.println(student2);

		session2.close();

	}
}
