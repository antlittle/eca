package com.eca.dao.impl.export;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eca.dao.export.ExportDao;

public class ExportDaoImpl implements ExportDao {
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
}
