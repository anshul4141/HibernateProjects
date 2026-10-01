package com.rays.crud;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;

public class TestAuthenticate {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();

		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");

		dto.setFirstName("s");

		// select * from UserDTO where 1=1;
		Criteria criteria = session.createCriteria(UserDTO.class);

		criteria.add(Restrictions.eq("login", dto.getLogin()));
		criteria.add(Restrictions.eq("password", dto.getPassword()));

		List<UserDTO> list = criteria.list();

		if (list.size() == 1) {
			dto = list.get(0);
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getPassword());

		} else {
			System.err.println("invalid login or password");
		}

	}
}