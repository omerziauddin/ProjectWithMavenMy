package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )throws IOException
    {
        System.out.println( "Hello World!" );
        //is a type of connection from which we can take out sessions and from sessions we can do crud
        //is thread safe and for 1 project it must be one and session will help us to do crud
        //sessionfactory > session>crud
        
        //SessionFactory is an interface so we need a class to make its object so Configuration class we will
        //use org.hibernate wala
        //Configuration hv a function configure from that we call buildSessionFactory which will return
        //session factory and that sessionfactory object will come inside variable factory below
        
        //can be done alias
        //xml file agar nai mil to provide name of  xml file
        //SessionFactory factory=new Configuration().configure().buildSessionFactory();
        //cfg will configure from all properties of xml file
        //configure want hibernate.cfg.xml file k path
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        //factory is used to create session and and do crud
        
        System.out.println(factory);
        //op org.hibernate.internal.SessionFactoryImpl@75361cf6   implementation class object
        
        System.out.println(factory.isClosed());
        //now we can use this factory object  factory to do crud
        
        
        //create object of student
        Student st=new Student();
        st.setId(104);
        st.setName("johntybhai");
        st.setCity("delhibelly2");
        
        System.out.println(st);
        
        //create object of address
        Address ad=new Address();
        ad.setStreet("street2");
        ad.setCity("Delhihinf");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.1234);
        
        //reading image we will read image using file input stream
        
        FileInputStream fis=new FileInputStream("src/main/java/wall.jpg");
        
        //we will make a byte type array to store data image object of length=fis.available()
        byte[] data=new byte[fis.available()];//available Returns an estimate of the number of remaining bytes that can be read
        fis.read(data);//Reads data from fis inputstream into an array of bytes
        //ad.setImage(data);//saving array of bytes containing image data into db
        
        //now i want to save st into db through hibernate
        
        //save method session k pass h aur y factory hame dega session .session interface h ek
       // video 5 18 mint
        
        
		/*
		 * ERROR No CurrentSessionContext configured! errorif using this bs we can get
		 * current session only if someone had created session now we hv to first make a
		 * session Session session=factory.getCurrentSession();
		 */
        Session session=factory.openSession();
        //before saving we hv to start transaction
        //then we hv to physically commit it to save changes in db
        //Ist way
		/*
		 * session.beginTransaction();// 1-session started transaction
		 * session.save(st);//2- object is saved session.getTransaction().commit();//3
		 * session gave us current transaction and 4-committed it
		 */
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        
        
         session.close();
    }
}/*
flow 
1- made student object
2-set data inside it through getter setter
3-save method session k pass tha isliye hame session niklna tha aur 3rd step me session nikala
Session session=factory.openSession(); factory returned a new opened  session

4-now through session we started transaction Transaction tx=session.beginTransaction();
aur jo bhi transaction start karo use ek tx variable me rakh do

5- save st object

6-we commited the transaction which we have ie tx
7-closed sessio*/

















