package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.map.Question;
import com.tut.Student;

public class CriteriaJavaBrains29 {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		Criteria criteria=session.createCriteria(Student.class);
		
		//criteria.add(Restrictions.eq("name", "peter")); //if using this then and will be added in 
		//hibernate where clause
		criteria.add(Restrictions.eq("certi.course", "android"))
		        .add(Restrictions.gt("id", 1235))
		        .add(Restrictions.like("certi.course", "and%"))
		        .add(Restrictions.between("id", 1230, 1260));
		List<Student> studentList=criteria.list();
		
		
		
		for(Student student : studentList )
		{
			System.out.println(student);
		}
        System.out.println("now second criteria");
		
		Criteria criteria2=session.createCriteria(Question.class);
		
		criteria2.add(Restrictions.or(
				Restrictions.gt("questionId", 560), Restrictions.like("question", "%python%")
				));             //for questionId>560   or   question like %python%
		
		List<Question> questionList=criteria2.list();
		
		for(Question question : questionList)
		{
			System.out.println(question);
			
		}
		
		session.getTransaction().commit();
		session.close();
	}

}
