package org.vimal.development.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vimal.development.hibernate.dto.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		UserDetails userDetails = new UserDetails();
		
		userDetails.setId(1);
		userDetails.setUserName("First User");
		
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(userDetails);
		
		session.getTransaction().commit();
		
		
	}

}
