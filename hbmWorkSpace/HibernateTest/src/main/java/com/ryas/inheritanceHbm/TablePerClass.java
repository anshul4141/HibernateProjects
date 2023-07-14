package com.ryas.inheritanceHbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TablePerClass {

	public static void main(String[] args) {

		CreditCardPayment cc = new CreditCardPayment();

		cc.setCcType("cctype");
		cc.setAmount(4563);

		Cheque cq = new Cheque();

		cq.setBankName("bob");
		cq.setChequeName("ibm");
		cq.setAmount(4569);

		Cash c = new Cash();

		c.setAmount(45698);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(cc);
		session.save(cq);
		session.save(c);

		tx.commit();
		session.close();

	}

}
