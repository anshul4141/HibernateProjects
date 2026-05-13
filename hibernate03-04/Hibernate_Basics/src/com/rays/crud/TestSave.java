package com.rays.crud;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestSave {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction(); // transaction begin

		UserDTO dto = new UserDTO();

		dto.setFirstName("Shyam");
		dto.setLastName("Yadav");
		dto.setLoginId("shyam@gmail.com");
		dto.setPassword("shyam123");
		dto.setDob(new Date());
		dto.setAddress("Indore");

		session.save(dto);

		tx.commit();

	}

}
