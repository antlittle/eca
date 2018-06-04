package com.eca.domain.DO;

public class eca_user {
	private String eca_user_id; // 用户id
	private String user_name; // 用户姓名
	private String user_username; // 用户名
	private String user_password; // 用户密码
	private String user_telphone; // 用户电话
	private String user_userRight; // 用户权限
	private String user_export_Right; // 导出权限
	private String user_manage_Right; // 管理权限
	private String user_gmt_create; // 创建时间
	private String user_gmt_modified; // 修改时间

	// -------------------------------------getter/setter--------------------------------------//

	public String getEca_user_id() {
		return eca_user_id;
	}

	public void setEca_user_id(String eca_user_id) {
		this.eca_user_id = eca_user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_telphone() {
		return user_telphone;
	}

	public void setUser_telphone(String user_telphone) {
		this.user_telphone = user_telphone;
	}

	public String getUser_userRight() {
		return user_userRight;
	}

	public void setUser_userRight(String user_userRight) {
		this.user_userRight = user_userRight;
	}

	public String getUser_export_Right() {
		return user_export_Right;
	}

	public void setUser_export_Right(String user_export_Right) {
		this.user_export_Right = user_export_Right;
	}

	public String getUser_manage_Right() {
		return user_manage_Right;
	}

	public void setUser_manage_Right(String user_manage_Right) {
		this.user_manage_Right = user_manage_Right;
	}

	public String getUser_gmt_create() {
		return user_gmt_create;
	}

	public void setUser_gmt_create(String user_gmt_create) {
		this.user_gmt_create = user_gmt_create;
	}

	public String getUser_gmt_modified() {
		return user_gmt_modified;
	}

	public void setUser_gmt_modified(String user_gmt_modified) {
		this.user_gmt_modified = user_gmt_modified;
	}

}