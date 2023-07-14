package com.rayas.projectionTest;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.rays.dto.UserDto;

public class ProjectionTest {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(UserDto.class);

		ProjectionList projList = Projections.projectionList();

		projList.add(Projections.property("id"));

		projList.add(Projections.property("firstName"));

		criteria.setProjection(projList);

		List list = criteria.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			Object[] object = (Object[]) it.next();

			System.out.print(object[0]);
			System.out.println("\t" + object[1]);

		}

	}
}
