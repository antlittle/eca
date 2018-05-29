package com.eca.dao.impl.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eca.dao.employee.StaffDao;
import com.eca.domain.DO.eca_staff;

public class StaffDaoImpl implements StaffDao {
	private SessionFactory sessionFactory;
	private final static String DELETE = "deleteSuccess";
	private final static String UPDATE = "updateSuccess";

	public SessionFactory getSessionFactory() {
		return sessionFactory;

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSessoin() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public String saveStaff(eca_staff staff) {
		// TODO Auto-generated method stub
		Session session = this.getSessoin();
		session.save(staff);
		return "saveSuccess";
	}

}
