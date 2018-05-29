package com.eca.domain.DO;

public class eca_staff {
	private String staff_id;
	private String staff_name;
	private String staff_sex;
	private String staff_eduBackground;
	private String staff_birthday;
	private String staff_department;
	private String staff_status;
	private String staff_phone;
	private String staff_address;
	private String staff_gmt_create;
	private String staff_gmt_modified;

	// --------------------------toStirng----------------------------------------//
	@Override
	public String toString() {
		return "eca_staff [staff_id=" + staff_id + ", staff_name=" + staff_name + ", staff_sex=" + staff_sex
				+ ", staff_eduBackground=" + staff_eduBackground + ", staff_birthday=" + staff_birthday
				+ ", staff_department=" + staff_department + ", staff_status=" + staff_status + ", staff_phone="
				+ staff_phone + ", staff_address=" + staff_address + ", staff_gmt_create=" + staff_gmt_create
				+ ", staff_gmt_modified=" + staff_gmt_modified + "]";
	}

	// --------------------------getter/setter----------------------------------------//
	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_sex() {
		return staff_sex;
	}

	public void setStaff_sex(String staff_sex) {
		this.staff_sex = staff_sex;
	}

	public String getStaff_eduBackground() {
		return staff_eduBackground;
	}

	public void setStaff_eduBackground(String staff_eduBackground) {
		this.staff_eduBackground = staff_eduBackground;
	}

	public String getStaff_birthday() {
		return staff_birthday;
	}

	public void setStaff_birthday(String staff_birthday) {
		this.staff_birthday = staff_birthday;
	}

	public String getStaff_department() {
		return staff_department;
	}

	public void setStaff_department(String staff_department) {
		this.staff_department = staff_department;
	}

	public String getStaff_status() {
		return staff_status;
	}

	public void setStaff_status(String staff_status) {
		this.staff_status = staff_status;
	}

	public String getStaff_phone() {
		return staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}

	public String getStaff_address() {
		return staff_address;
	}

	public void setStaff_address(String staff_address) {
		this.staff_address = staff_address;
	}

	public String getStaff_gmt_create() {
		return staff_gmt_create;
	}

	public void setStaff_gmt_create(String staff_gmt_create) {
		this.staff_gmt_create = staff_gmt_create;
	}

	public String getStaff_gmt_modified() {
		return staff_gmt_modified;
	}

	public void setStaff_gmt_modified(String staff_gmt_modified) {
		this.staff_gmt_modified = staff_gmt_modified;
	}

}
