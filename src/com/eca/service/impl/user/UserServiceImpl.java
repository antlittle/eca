package com.eca.service.impl.user;

import java.util.List;

import com.eca.dao.user.UserDao;
import com.eca.domain.DO.eca_user;
import com.eca.domain.VO.showUserVO;
import com.eca.service.user.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 得到用户名
	public eca_user getUserByUsername(String user_username) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(user_username);
	}

	public void addUser(eca_user eu) {
		// TODO Auto-generated method stub
		eu.setUser_password(eu.getUser_password());
		userDao.addUser(eu);
	}

	public eca_user getUserById(String eca_user_id) {
		// TODO Auto-generated method stub
		eca_user eu = userDao.getUserById(eca_user_id);
		return eu;
	}

	public void updateUser(eca_user eu) {
		// TODO Auto-generated method stub
		userDao.updateUser(eu);
	}

	public void deleteUser(String eca_user_id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(eca_user_id);

	}

	public boolean judgeUserByUsername(String user_username) {
		// TODO Auto-generated method stub
		return userDao.judgeUserByUsername(user_username);
	}

	public void updatePassword(String eca_user_id, String newPassword) {
		// TODO Auto-generated method stub
		userDao.updatePassword(eca_user_id, newPassword);
	}

	public showUserVO getUserByPage(String queryString, int currPage) {
		// TODO Auto-generated method stub
		showUserVO suv = new showUserVO();

		suv.setCurrPage(currPage);
		suv.setQueryString(queryString);
		suv.setPageSize(10);

		int count = userDao.getUserCount(queryString, currPage);

		suv.setCount(count);
		double c = count;
		int totalPage = (int) Math.ceil(c / 10);
		suv.setTotalPage(totalPage);

		List<eca_user> list = userDao.getUserByPage(queryString, currPage);
		suv.setList(list);
		return suv;

	}

}
