package com.rays.oneTOone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToOne {

	public static void main(String[] args) {

		Address address = new Address();

		address.setId(1);
		address.setState("MP");
		address.setCity("Indore");

		Employee employee = new Employee();

		employee.setId(1);
		employee.setFirstName("Anshul");
		employee.setLastName("Prajapati");
		employee.setEmpAddress(address);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();

	}

}
