package com.rays.TestCRUD;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDto;

public class GetUser {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDto dto = (UserDto) session.get(UserDto.class, 1);

		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getSalary());


		UserDto dto2 = (UserDto) session.get(UserDto.class, 1);

		System.out.println(dto2.getId());
		System.out.println(dto2.getFirstName());
		System.out.println(dto2.getLastName());
		System.out.println(dto2.getSalary());

	}

}
