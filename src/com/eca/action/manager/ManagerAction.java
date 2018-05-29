package com.eca.action.manager;

import com.eca.domain.DO.eca_list;
import com.eca.service.manager.ManagerService;

public class ManagerAction {
	private ManagerService managerService;
	private eca_list list;

	public String intoMain() {
		return "intoMain";
	}

	public void saveList() {
		boolean flag = managerService.saveList(list);
	}

	public eca_list getList() {
		return list;
	}

	public void setList(eca_list list) {
		this.list = list;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
}
