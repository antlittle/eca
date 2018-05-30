package com.eca.domain.DTO;

public class staffListDTO {
	private String staff_id;
	private String staff_name;
	private String staff_sex;
	private String staff_birthday;
	private String staff_status;
	private String staff_gmt_create;

	// -------------------------------------------getter/setter----------------------------------------------//
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

	public String getStaff_birthday() {
		return staff_birthday;
	}

	public void setStaff_birthday(String staff_birthday) {
		this.staff_birthday = staff_birthday;
	}

	public String getStaff_status() {
		return staff_status;
	}

	public void setStaff_status(String staff_status) {
		this.staff_status = staff_status;
	}

	public String getStaff_gmt_create() {
		return staff_gmt_create;
	}

	public void setStaff_gmt_create(String staff_gmt_create) {
		this.staff_gmt_create = staff_gmt_create;
	}

	// --------------------------------------------end-------------------------------------------------//
	@Override
	public String toString() {
		return "staffListDTO [staff_id=" + staff_id + ", staff_name=" + staff_name + ", staff_sex=" + staff_sex
				+ ", staff_birthday=" + staff_birthday + ", staff_status=" + staff_status + ", staff_gmt_create="
				+ staff_gmt_create + "]";
	}

	public staffListDTO(String staff_id, String staff_name, String staff_sex, String staff_birthday,
			String staff_status, String staff_gmt_create) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.staff_sex = staff_sex;
		this.staff_birthday = staff_birthday;
		this.staff_status = staff_status;
		this.staff_gmt_create = staff_gmt_create;
	}

}
