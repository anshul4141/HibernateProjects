package com.rays.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class UserModel {

	public int add(UserDTO dto) throws Exception {

		UserDTO existDto = findByLogin(dto.getLoginId());

		if (existDto != null) {
			throw new Exception("login already exists");
		}

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction(); // transaction begin

		session.save(dto);

		tx.commit();

		return dto.getId();

	}

	public void update(UserDTO dto) throws Exception {

		UserDTO existDto = findByLogin(dto.getLoginId());

		if (existDto != null) {
			throw new Exception("login already exists");
		}

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction(); // transaction begin

		session.update(dto);

		tx.commit();

	}

	public void delete(UserDTO dto) throws Exception {

		UserDTO existDto = findByLogin(dto.getLoginId());

		if (existDto != null) {
			throw new Exception("login already exists");
		}

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction(); // transaction begin

		session.delete(dto);

		tx.commit();

	}

	public UserDTO findByLogin(String login) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		// select * from UserDTO where 1 = 1;
		Criteria criteria = session.createCriteria(UserDTO.class);

		// select * from UserDTO where 1 = 1 and where loginId = ?;
		criteria.add(Restrictions.eq("loginId", login));

		List<UserDTO> list = criteria.list();

		if (list.size() == 1) {
			dto = new UserDTO();
			dto = list.get(0);
		}

		return dto;

	}

	public UserDTO authenticate(String login, String password) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		// select * from UserDTO where 1 = 1;
		Criteria criteria = session.createCriteria(UserDTO.class);

		// select * from UserDTO where 1 = 1 and where loginId = ?;
		criteria.add(Restrictions.eq("loginId", login));
		criteria.add(Restrictions.eq("password", password));

		List<UserDTO> list = criteria.list();

		if (list.size() == 1) {
			dto = new UserDTO();
			dto = list.get(0);
		}

		return dto;

	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		// select * from UserDTO where 1 = 1;
		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getLoginId() != null && dto.getLoginId().length() > 0) {
				criteria.add(Restrictions.eq("loginId", dto.getLoginId()));
			}
			if (dto.getPassword() != null && dto.getPassword().length() > 0) {
				criteria.add(Restrictions.eq("password", dto.getPassword()));
			}
			if (dto.getDob() != null && dto.getDob().getTime() > 0) {
				criteria.add(Restrictions.eq("dob", dto.getDob()));
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo); // Initial index
			criteria.setMaxResults(pageSize); // Number of records
		}

		List<UserDTO> list = criteria.list();

		return list;

	}

}
