package com.rays.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDto;

public class TestCriteria {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDto dto = new UserDto();

		Criteria criteria = session.createCriteria(UserDto.class);

		List list = criteria.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDto) it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getSalary());

		}

	}
}