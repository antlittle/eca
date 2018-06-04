package com.eca.action.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.eca.domain.DO.eca_staff;
import com.eca.domain.VO.staffListVO;
import com.eca.service.employee.StaffService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class StaffAction extends ActionSupport {
	private String staff_id;
	private StaffService staffService;
	private eca_staff staff;
	private staffListVO staffVO;

	// -----------------------------------进入人员管理---------------------------------------//
	public String page_staffList() {
		return "StaffIndex";
	}

	public String page_addStaff() {
		return "AddStaff";
	}

	public String intoUpdate() {
		return "intoUpdate";
	}

	// -----------------------------------添加员工---------------------------------------//
	public void saveStaff() {
		String result = staffService.saveStaff(staff);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(staff.getStaff_id());
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 修改员工
	public void updateStaff() {
		System.out.println(staff);
		eca_staff oldStaff = staffService.getStaffByStaffId(staff.getStaff_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charSet=utf-8");
		staff.setStaff_gmt_create(oldStaff.getStaff_gmt_create());
		String result = staffService.updateStaff(staff);
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 根据ID获得员工
	public void getStaffByStaffId() {
		eca_staff thisStaff = staffService.getStaffByStaffId(staff.getStaff_id());
		Gson gson = new Gson();
		String result = gson.toJson(thisStaff);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charSet=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 删除员工
	public void deleteStaff() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charSet=utf-8");
		String result = staffService.deleteStaff(staff);
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// -------------------------------------显示员工信息分页-------------------------------------//
	public void getStaffsByPage() {
		staffService.getStaffsByPage(staffVO);
		Gson gson = new Gson();
		String result = gson.toJson(staffVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charSet=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	// ------------------------------------getter/setter--------------------------------//

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public eca_staff getStaff() {
		return staff;
	}

	public void setStaff(eca_staff staff) {
		this.staff = staff;
	}

	public staffListVO getStaffVO() {
		return staffVO;
	}

	public void setStaffVO(staffListVO staffVO) {
		this.staffVO = staffVO;
	}

}
