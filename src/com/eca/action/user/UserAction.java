package com.eca.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.eca.domain.DO.eca_user;
import com.eca.domain.VO.showUserVO;
import com.eca.service.user.UserService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import util.TeamUtil;

public class UserAction extends ActionSupport {
	private UserService userService;

	public String implements_navbar() {
		return "navbar_";
	}

	public String intoIndex() {
		return "intoIndex";
	}

	public String intoMain() {
		return "intoMain";
	}

	public String skipToUser() {
		return "skipToUser";
	}

	// --------------------------以上为页面引入

	// --------------------------以下为setter/getter方法
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 登录
	public void login() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (!userService.judgeUserByUsername(user_username)) {
			pw.write("userNoExist");
		} else {
			eca_user user = userService.getUserByUsername(user_username);
			String password = user_password;
			if (user.getUser_password().equals(password)) {
				pw.write("loginSuccess");
				ActionContext.getContext().getSession().put("eca_user_id", user.getEca_user_id());
				ActionContext.getContext().getSession().put("user_name", user.getUser_name());
			} else {
				pw.write("passwordError");
			}
			pw.flush();
			pw.close();
		}
	}

	// 退出注销
	public String logout() {
		ActionContext.getContext().getSession().remove("eca_user_id");
		ActionContext.getContext().getSession().remove("user_name");
		return "logoutSuccess";
	}

	// 修改密码
	public void updatePassword() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html；charset=utf-8");
		PrintWriter pw = response.getWriter();
		String eca_user_id = (String) ActionContext.getContext().getSession().get("eca_user_id");
		if (eca_user_id != null || eca_user_id != "") {
			eca_user ru = userService.getUserById(eca_user_id);
			if (ru.getUser_password().equals(oldPassword)) {
				userService.updatePassword(eca_user_id, newPassword);
				pw.write("updateSuccess");
			} else {
				pw.write("oldPasswordError");
			}
		} else {
			pw.write("updateFail");
		}
	}

	// 添加用户
	public void addUser() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset:utf-8;");
		PrintWriter pw = response.getWriter();
		eca_user eu = new eca_user();
		eu.setEca_user_id(TeamUtil.getUuid());
		eu.setUser_name(user_name);
		eu.setUser_password(user_password);
		eu.setUser_telphone(user_telphone);
		eu.setUser_gmt_create(user_gmt_create);
		eu.setUser_gmt_modified(user_gmt_modified);
		eu.setUser_export_Right(user_export_Right);
		eu.setUser_manage_Right(user_manage_Right);
		eu.setUser_userRight(user_userRight);
		eu.setUser_gmt_create(TeamUtil.getStringSecond());
		eu.setUser_gmt_modified(TeamUtil.getStringSecond());
		if (userService.judgeUserByUsername(user_username)) {
			pw.write("用户名存在");
		} else {
			eu.setUser_username(user_username);
			userService.addUser(eu);
			pw.write("添加成功");
		}
		pw.flush();
		pw.close();
	}

	// 删除用户
	public void deleteUser() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		userService.deleteUser(eca_user_id);
		PrintWriter pw = response.getWriter();
		pw.write("删除成功");
		pw.flush();
		pw.close();
	}

	// 修改用户
	public void updateUser() throws IOException {
		System.out.println(eca_user_id);
		eca_user euGet = userService.getUserById(eca_user_id);
		eca_user eu = new eca_user();
		eu.setEca_user_id(eca_user_id);
		eu.setUser_name(user_name);
		eu.setUser_username(user_username);
		eu.setUser_telphone(user_telphone);
		eu.setUser_export_Right(user_export_Right);
		eu.setUser_manage_Right(user_manage_Right);
		eu.setUser_userRight(user_userRight);
		eu.setUser_gmt_create(euGet.getUser_gmt_create());
		eu.setUser_gmt_modified(TeamUtil.getStringSecond());

		if (user_password == "" || user_password.equals("")) {
			eu.setUser_password(euGet.getUser_password());
		} else {
			eu.setUser_password(user_password);
		}
		userService.updateUser(eu);
	}

	// 得到用户
	public void getUser() throws IOException {
		showUserVO suv = userService.getUserByPage(queryString, currPage);
		Gson gson = new Gson();
		System.out.println(gson);
		String result = gson.toJson(suv);
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	};

	// 根据ID得到用户
	public void getUserById() throws IOException {
		eca_user eu = userService.getUserById(eca_user_id);
		Gson gson = new Gson();
		String result = gson.toJson(eu);
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();

	}

	// -------------------------------------------------------------------------------------------------//
	private String queryString;
	private int currPage;
	private String eca_user_id;
	private String user_name;
	private String user_username;
	private String user_password;
	private String user_telphone;
	private String oldPassword;
	private String newPassword;
	private String user_userRight;
	private String user_export_Right;
	private String user_manage_Right;
	private String user_gmt_create;
	private String user_gmt_modified;

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String getEca_user_id() {
		return eca_user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public void setEca_user_id(String eca_user_id) {
		this.eca_user_id = eca_user_id;
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
