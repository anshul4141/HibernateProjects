package com.rays.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestInsert {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction(); // transaction begin

		UserDTO dto = new UserDTO();

		dto.setFirstName("Shyam");
		dto.setLastName("Yadav");
		dto.setLogin("shyam@gmail.com");
		dto.setPassword("shyam123");

		session.save(dto);

		tx.commit();

	}

}
