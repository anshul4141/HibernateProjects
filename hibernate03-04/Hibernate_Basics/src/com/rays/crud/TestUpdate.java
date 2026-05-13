package com.rays.crud;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestUpdate {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction(); // transaction begin

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Pawan");
		dto.setLastName("Pawar");
		dto.setLoginId("pawan@gmail.com");
		dto.setPassword("pawan123");
		dto.setDob(new Date());
		dto.setAddress("Indore");

		session.update(dto);

		tx.commit();

	}

}
