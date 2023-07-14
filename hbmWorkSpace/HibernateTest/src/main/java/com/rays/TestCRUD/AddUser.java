package com.rays.TestCRUD;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDto;

public class AddUser {

	public static void main(String[] args) {

		UserDto dto = new UserDto();
		dto.setFirstName("Cool");
		dto.setLastName("Deep");
		dto.setSalary(60000);
		

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(dto);
		//session.delete(dto);
		//session.update(dto);

		tx.commit();

	}

}
