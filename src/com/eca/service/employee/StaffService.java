package com.eca.service.employee;

import com.eca.domain.DO.eca_staff;
import com.eca.domain.VO.staffListVO;

public interface StaffService {
	// 添加员工
	String saveStaff(eca_staff staff);

	// 得到员工信息分页
	void getStaffsByPage(staffListVO staffVO);

	// 修改员工信息
	String updateStaff(eca_staff staff);

	// 根据ID获得员工
	eca_staff getStaffByStaffId(String staff_id);

	// 删除员工
	String deleteStaff(eca_staff staff);
}
