package com.rays.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class UserModel {

	public int add(UserDTO dto) {

		Session session = null;

		try {

			session = HibDataSource.getSession();

			Transaction tx = session.beginTransaction();

			session.save(dto);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibDataSource.closeSession(session);
		}

		return dto.getId();

	}

	public void update(UserDTO dto) {

		Session session = null;

		try {

			session = HibDataSource.getSession();

			Transaction tx = session.beginTransaction();

			session.update(dto);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibDataSource.closeSession(session);
		}

	}

	public void delete(int id) {

		Session session = null;

		try {

			session = HibDataSource.getSession();

			Transaction tx = session.beginTransaction();

			session.delete(id);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibDataSource.closeSession(session);
		}

	}

	public UserDTO findByPk(int id) {

		Session session = null;

		UserDTO dto = new UserDTO();

		try {
			session = HibDataSource.getSession();
			dto = (UserDTO) session.get(UserDTO.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibDataSource.closeSession(session);
		}

		return dto;

	}

	public UserDTO findByLogin(String login) {

		Session session = null;

		UserDTO dto = null;

		try {

			session = HibDataSource.getSession();

			// select * from UserDTO where 1=1;
			Criteria criteria = session.createCriteria(UserDTO.class);

			// and login = ?;
			criteria.add(Restrictions.eq("login", login));

			List<UserDTO> list = criteria.list();

			if (list.size() == 1) {
				dto = new UserDTO();
				dto = list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibDataSource.closeSession(session);
		}

		return dto;

	}

	public UserDTO authenticate(String login, String password) {

		UserDTO dto = findByLogin(login);

		if (dto != null && dto.getPassword().equals(password)) {
			return dto;
		}

		return null;

	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		Session session = null;
		List<UserDTO> list = new ArrayList<UserDTO>();

		try {

			session = HibDataSource.getSession();

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

			if (pageSize > 0) {
				// limit index, totalRecord;
				criteria.setFirstResult((pageNo - 1) * pageSize); // index
				criteria.setMaxResults(pageSize); // total number of records;
			}

			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibDataSource.closeSession(session);
		}

		return list;

	}

}
