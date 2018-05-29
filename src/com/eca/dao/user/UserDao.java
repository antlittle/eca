package com.eca.dao.user;

import java.util.List;

import com.eca.domain.DO.eca_user;

public interface UserDao {

	// 得到用户id
	public eca_user getUserById(String eca_user_id);

	// 得到用户名
	public eca_user getUserByUsername(String user_username);

	// 判断用户是否存在
	public boolean judgeUserByUsername(String user_username);

	// 修改密码
	public void updatePassword(String eca_user_id, String newPassword);

	// 添加用户
	public void addUser(eca_user eu);

	// 删除用户
	public void deleteUser(String eca_user_id);

	// 修改用户
	public void updateUser(eca_user eu);

	// 得到用户总数
	int getUserCount(String queryString, int currPage);

	// 得到用户列表
	List<eca_user> getUserByPage(String queryString, int currPage);

}
