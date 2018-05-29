package com.eca.service.impl.manager;

import com.eca.dao.manager.ManagerDao;
import com.eca.domain.DO.eca_list;
import com.eca.service.manager.ManagerService;

import util.TeamUtil;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public boolean saveList(eca_list rList) {
		// TODO Auto-generated method stub

		rList.setEca_list_id(TeamUtil.getUuid());
		rList.setList_gmt_create(TeamUtil.getStringSecond());
		rList.setList_gmt_modified(TeamUtil.getStringSecond());
		boolean flag = managerDao.saveList(rList);
		return false;
	}

}
