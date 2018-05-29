package com.eca.dao.impl.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eca.dao.user.UserDao;
import com.eca.domain.DO.eca_user;

public class UserDaoImpl implements UserDao {
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

	// 得到用户名
	public eca_user getUserByUsername(String user_username) {
		// TODO Auto-generated method stub
		String hql = "from eca_user where user_username = '" + user_username + "'";
		Query query = getSession().createQuery(hql);
		List<eca_user> list = query.list();
		return list.get(0);
	}

	// 判断用户是否存在
	public boolean judgeUserByUsername(String user_username) {
		// TODO Auto-generated method stub
		String hql = "from eca_user where user_username = '" + user_username + "'";
		Query query = getSession().createQuery(hql);
		List<eca_user> list = query.list();
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	// 修改密码
	public void updatePassword(String eca_user_id, String newPassword) {
		// TODO Auto-generated method stub
		String hql = "update eca_user set user_password ='" + newPassword + "' where eca_user_id = '" + eca_user_id
				+ "'";
		getSession().createQuery(hql).executeUpdate();
	}

	// 根据ID得到用户
	public eca_user getUserById(String eca_user_id) {
		// TODO Auto-generated method stub
		eca_user eu = (eca_user) getSession().get(eca_user.class, eca_user_id);
		return eu;
	}

	// 得到用户总数
	public int getUserCount(String queryString, int currPage) {
		String query = "%" + queryString + "%";
		String hql = "select count(*) from eca_user where (user_name like '" + query + "' or user_telphone like '"
				+ query + "' or user_gmt_create like '" + query + "' or user_username like '" + query + "')";
		System.out.println(hql);
		int count = ((Number) getSession().createQuery(hql).uniqueResult()).intValue();
		return count;

	}

	// 得到用户列表
	public List<eca_user> getUserByPage(String queryString, int currPage) {
		String query = "%" + queryString + "%";
		String hql = "from eca_user where (user_name like '" + query + "' or user_telphone like '" + query
				+ "' or user_gmt_create like '" + query + "' or user_username like '" + query + "') ";
		System.out.println(hql);
		List<eca_user> list = getSession().createQuery(hql).setFirstResult((currPage - 1) * 10).setMaxResults(10)
				.list();
		return list;
	}

	// 添加用户
	public void addUser(eca_user eu) {
		// TODO Auto-generated method stub
		getSession().save(eu);
	}

	// 删除用户
	public void deleteUser(String eca_user_id) {
		String hql = "delete from eca_user where eca_user_id = '" + eca_user_id + "'";
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		query.executeUpdate();
	}

	// 修改用户
	public void updateUser(eca_user eu) {
		getSession().saveOrUpdate(eu);
	}
}
