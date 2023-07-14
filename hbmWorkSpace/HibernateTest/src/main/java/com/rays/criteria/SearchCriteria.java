package com.rays.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDto;

public class SearchCriteria {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDto dto = new UserDto();

		Criteria criteria = session.createCriteria(UserDto.class);

		criteria.add(Restrictions.like("firstName", "jayati"));
		criteria.add(Restrictions.like("lastName", "chouhan"));

		List list = criteria.list();

		dto = (UserDto) list.get(0);

		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getSalary());
	}

}
