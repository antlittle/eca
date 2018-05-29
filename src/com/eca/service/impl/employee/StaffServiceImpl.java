package com.eca.service.impl.employee;

import com.eca.dao.employee.StaffDao;
import com.eca.domain.DO.eca_staff;
import com.eca.service.employee.StaffService;

import util.TeamUtil;

public class StaffServiceImpl implements StaffService {
	private StaffDao staffDao;

	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public String saveStaff(eca_staff staff) {
		// TODO Auto-generated method stub
		System.out.println(staff);
		staff.setStaff_id(TeamUtil.getUuid());
		staff.setStaff_gmt_create(TeamUtil.getStringSecond());
		staff.setStaff_gmt_modified(TeamUtil.getStringSecond());
		String result = staffDao.saveStaff(staff);
		return result;
	}

}
