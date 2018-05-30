package com.eca.domain.VO;

import java.util.List;

import com.eca.domain.DTO.staffListDTO;

public class staffListVO {
	private int totalCount;
	private int currPage;
	private int pageCount;
	private int totalPage;
	private String staffJoinTime = "desc";
	private String staffStatus;
	private String staffName;
	private String staffSex;
	private List<staffListDTO> staffs;

	// -------------------------------------------getter/setter----------------------------------------//
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getStaffJoinTime() {
		return staffJoinTime;
	}

	public void setStaffJoinTime(String staffJoinTime) {
		this.staffJoinTime = staffJoinTime;
	}

	public String getStaffStatus() {
		return staffStatus;
	}

	public void setStaffStatus(String staffStatus) {
		this.staffStatus = staffStatus;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffSex() {
		return staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}

	public List<staffListDTO> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<staffListDTO> staffs) {
		this.staffs = staffs;
	}

}
