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

	// -----------------------------------添加员工---------------------------------------//
	public void saveStaff() {
		System.out.println(staff);
		String result = staffService.saveStaff(staff);
		System.out.println("fadsfadsfasdf");
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
