package com.eca.dao.employee;

import java.util.List;

import com.eca.domain.DO.eca_staff;
import com.eca.domain.DTO.staffListDTO;
import com.eca.domain.VO.staffListVO;

public interface StaffDao {
	// 添加员工
	String saveStaff(eca_staff staff);

	// 添加员工列表
	List<staffListDTO> getStaffsByPage(staffListVO staffVO);

	// 得到员工总数
	int getStaffsCount(staffListVO staffVO);
}
