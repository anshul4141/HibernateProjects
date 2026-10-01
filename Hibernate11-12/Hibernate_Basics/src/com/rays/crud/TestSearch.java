package com.rays.crud;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;

public class TestSearch {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = new UserDTO();

		dto.setFirstName("s");

		// select * from UserDTO where 1=1;
		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
		}

		List<UserDTO> list = criteria.list();

		Iterator<UserDTO> it = list.iterator();

		while (it.hasNext()) {
			dto = it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getPassword());

		}

	}

}
