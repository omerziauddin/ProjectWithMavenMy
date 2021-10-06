package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//mapping entity class to table using xml and not annotation
public class Test {

	public static void main(String[] args) {
		//agar config file hibernate ki kahi aur h to full path name likha jayga
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Person person = new Person(23, "Ram", "Delhi", "52524");

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(person);

		tx.commit();
		session.close();

		factory.close();

	}

}
