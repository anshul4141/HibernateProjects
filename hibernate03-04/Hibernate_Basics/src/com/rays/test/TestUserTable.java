package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestUserTable {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();

		dto.setId(1);

		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();

	}

}
