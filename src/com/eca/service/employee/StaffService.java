package com.eca.service.employee;

import com.eca.domain.DO.eca_staff;
import com.eca.domain.VO.staffListVO;

public interface StaffService {
	// 添加员工
	String saveStaff(eca_staff staff);

	// 得到员工信息分页
	void getStaffsByPage(staffListVO staffVO);
}
