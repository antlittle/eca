package com.eca.dao.impl.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eca.dao.manager.ManagerDao;
import com.eca.domain.DO.eca_list;

public class ManagerDaoImpl implements ManagerDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean saveList(eca_list rList) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		try {
			session.save(rList);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
}
