package com.eca.dao.impl.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eca.dao.employee.StaffDao;
import com.eca.domain.DO.eca_staff;
import com.eca.domain.DTO.staffListDTO;
import com.eca.domain.VO.staffListVO;

public class StaffDaoImpl implements StaffDao {
	private SessionFactory sessionFactory;
	private final static String DELETE = "deleteSuccess";
	private final static String UPDATE = "updateSuccess";

	public SessionFactory getSessionFactory() {
		return sessionFactory;

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	// 添加员工
	@Override
	public String saveStaff(eca_staff staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.save(staff);
		return "saveSuccess";
	}

	// 得到员工列表
	@Override
	public List<staffListDTO> getStaffsByPage(staffListVO staffVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.eca.domain.DTO.staffListDTO(x.staff_id as staff_id,x.staff_name as staff_name,"
				+ "x.staff_sex as staff_sex,x.staff_birthday as staff_birthday,x.staff_status as staff_staffstatus,x.staff_gmt_create as staff_gmt_create) from eca_staff x where 1=1 ";
		if (staffVO.getStaffName() != null && staffVO.getStaffName().trim().length() > 0) {
			String name = "%" + staffVO.getStaffName() + "%";
			hql = hql + " and staff_name like '" + name + "'";
		}
		if (staffVO.getStaffSex() != null && staffVO.getStaffSex().trim().length() > 0) {
			String sex = "%" + staffVO.getStaffSex() + "%";
			hql = hql + " and staff_sex like '" + sex + "'";
		}
		if (staffVO.getStaffStatus() != null && staffVO.getStaffStatus().trim().length() > 0) {
			String status = "%" + staffVO.getStaffStatus() + "%";
			hql = hql + " and staff_status like '" + status + "'";
		}
		hql = hql + " order by staff_gmt_create " + staffVO.getStaffJoinTime();
		Session session = this.getSession();
		List<staffListDTO> staffs = session.createQuery(hql)
				.setFirstResult((staffVO.getCurrPage() - 1) * staffVO.getPageCount())
				.setMaxResults(staffVO.getPageCount()).list();
		session.clear();
		for (staffListDTO staffListDTO : staffs) {
			if (staffListDTO.getStaff_name() != null && staffListDTO.getStaff_name().trim().length() > 0) {
				staffListDTO.setStaff_name(staffListDTO.getStaff_name().replaceAll(staffVO.getStaffName(),
						"<span style='color:red;'>" + staffVO.getStaffName() + "</span>"));
			}
		}
		return staffs;
	}

	// 得到员工总数
	@Override
	public int getStaffsCount(staffListVO staffVO) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from eca_staff where 1=1";
		if (staffVO.getStaffName() != null && staffVO.getStaffName().trim().length() > 0) {
			String name = "%" + staffVO.getStaffName() + "%";
			hql = hql + " and staff_name like '" + name + "'";
		}
		if (staffVO.getStaffSex() != null && staffVO.getStaffSex().trim().length() > 0) {
			String sex = "%" + staffVO.getStaffSex() + "%";
			hql = hql + " and staff_sex like '" + sex + "'";
		}
		if (staffVO.getStaffStatus() != null && staffVO.getStaffStatus().trim().length() > 0) {
			String status = "%" + staffVO.getStaffStatus() + "%";
			hql = hql + " and staff_status like '" + status + "'";
		}
		hql = hql + " order by staff_gmt_create " + staffVO.getStaffJoinTime();
		Session session = this.getSession();
		long count;
		count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	// 根据ID获得员工
	public eca_staff getStaffByStaffId(String staff_id) {
		Session session = this.getSession();
		return (eca_staff) session.get(eca_staff.class, staff_id);
	}

	// 修改员工信息
	@Override
	public String updateStaff(eca_staff staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.saveOrUpdate(staff);
		return UPDATE;
	}

	// 删除员工
	@Override
	public String deleteStaff(eca_staff staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.delete(staff);
		return DELETE;
	}

}
