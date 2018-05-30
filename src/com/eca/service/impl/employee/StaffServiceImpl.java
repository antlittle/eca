package com.eca.service.impl.employee;

import java.util.List;

import com.eca.dao.employee.StaffDao;
import com.eca.domain.DO.eca_staff;
import com.eca.domain.DTO.staffListDTO;
import com.eca.domain.VO.staffListVO;
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

	// 添加员工
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

	// 得到员工列表
	@Override
	public void getStaffsByPage(staffListVO staffVO) {
		// TODO Auto-generated method stub
		int count = staffDao.getStaffsCount(staffVO);
		staffVO.setTotalPage((int) Math.ceil((double) count / (double) staffVO.getPageCount()));
		staffVO.setTotalCount(count);
		List<staffListDTO> staffs = staffDao.getStaffsByPage(staffVO);
		staffVO.setStaffs(staffs);
	}

}
