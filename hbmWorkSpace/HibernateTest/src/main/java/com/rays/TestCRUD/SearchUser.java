package com.rays.TestCRUD;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDto;

public class SearchUser {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDto dto = new UserDto();

		Query q = session.createQuery("from UserDto where firstName = ? and lastName = ?");

		q.setString(0, "ABCD");
		q.setString(1, "JDBC");

		List l = q.list();

		if (l.size() > 0) {

			dto = (UserDto) l.get(0);

			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getSalary());

		} else {
			System.err.println("invalid");
		}

		session.close();

	}

}
