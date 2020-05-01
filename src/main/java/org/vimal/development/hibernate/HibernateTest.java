package org.vimal.development.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vimal.development.hibernate.dto.Address;
import org.vimal.development.hibernate.dto.UserDetails;


public class HibernateTest {
	
	public static void main(String[] args) {
		
		UserDetails userDetails = new UserDetails();
		
		
		userDetails.setUserName("Third User");
		Address address = new Address();
		address.setStreet("street");
		address.setCity("city");
		address.setState("state");
		address.setPinCode("pin code");
		
//		Set<Address> addressList = new HashSet<Address>();
//		
//		addressList.add(address);
//		userDetails.setAddressList(addressList);
		userDetails.getAddressList().add(address);
		
		
		
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(userDetails);
		
		session.getTransaction().commit();
		
		session.close();
		
		
// 		retrieving data from table				
//		userDetails = null;
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		userDetails = (UserDetails) session.get(UserDetails.class, 3);
//		
//		System.out.println("user name retrieved : " + userDetails.getUserName());
		
		
		
		
	}

}
