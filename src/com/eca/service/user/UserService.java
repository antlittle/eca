package com.eca.service.user;

import com.eca.domain.DO.eca_user;
import com.eca.domain.VO.showUserVO;

public interface UserService {
	public showUserVO getUserByPage(String queryString, int currPage);

	public eca_user getUserByUsername(String user_username);

	public void addUser(eca_user eu);

	public eca_user getUserById(String eca_user_id);

	public void updateUser(eca_user eu);

	public void deleteUser(String eca_user_id);

	public boolean judgeUserByUsername(String user_username);

	public void updatePassword(String eca_user_id, String newPassword);

}
