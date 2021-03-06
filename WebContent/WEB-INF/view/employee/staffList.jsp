<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>人员管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath%>css/employee/employee.css">
<script type="text/javascript" src="<%=basePath%>js/employee/showStaffInfo.js"></script>
</head>sert title here</title>
</head>
<body>
	<s:action name="user_implements_navbar" namespace="/user" executeResult="true" />
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin:80px 0 0 0; float: left; width: 100%;">
		<div class="panel" style="width: 95%; margin: 20px auto;" id="allPage">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">人员管理</h3>
			</div>
			<div class="panel-body">
				<div class="operation" style="margin: 0 0 6px 50px;">
					<input type="text" id="searchInput" class="form-control" style="width: 220px; display: inline-block; float:right; position:relative ; right:15px;" oninput="changeName(this)" placeholder="请输入搜索内容">
					<a style="margin-left: 820px;" type="button"
						class="btn btn-default"
						href="<%=basePath%>staff/staff_page_addStaff">
						<i class="fa fa-plus-square"></i> 添加人员
					</a>
				</div>
				<div class="col-md-12">
				<div id="loadingLayer"  style="margin: 0 auto; width: 45px;"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></div>
					<div class="panel" id="mainPanel" style="display: none;">
						<div class="panel-heading">
							<h3 class="panel-title staff_title">人员列表</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-condensed staff_table_info">
								<thead>
									<tr>
										<th>姓名</th>
										<th><select id="staff_sex" onchange="changeSex(this)" class="form-control">
											<option value="">性别</option>
											<option value="男">男</option>
											<option value="女">女</option>
										</select>
										</th>
										<th>出生年月</th>
										<th><select id="staff_status" onchange="changeStatus(this)" class="form-control">
											<option value="">职位</option>
											<option value="总经理">总经理</option>
											<option value="部门经理">部门经理</option>
											<option value="部门主管">部门主管</option>
											<option value="职员">职员</option>
										</select></th>
										<th><select id="staff_gmt_create" onchange="changeSort(this)" class="form-control">
											<option value="desc">入职时间（降序）</option>
											<option value="asc">入职时间（升序）</option>
										</select> </th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<tr v-for="staff in staffs" style="text-align: center;">
										<td><a :id="staff.staff_id" onclick="skipToDetails(this)"><span v-html="staff.staff_name"></span></a></td>
										<td>{{ staff.staff_sex }}</td>
										<td>{{ staff.staff_birthday }}</td>
										<td>{{ staff.staff_status }}</td>
										<td>{{ staff.staff_gmt_create}}</td>
										<td><button  onclick="createConfirm_relive(this)" :id="staff.staff_id" class="btn btn-primary">修改</button>
										<button  onclick="createConfirm(this)" :id="staff.staff_id" class="btn btn-danger">删除</button></td>
									</tr>
								</tbody>
							</table>
							<div class="page-footer">
								<div class="page_info">
									&nbsp;&nbsp;&nbsp;&nbsp; <a onclick="firstPage()"><i
										class="fa fa-angle-double-left">首页</i></a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a onclick="prePage()"><i class="fa fa-angle-left"></i>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a onclick="nextPage()">下一页<i class="fa fa-angle-right"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a onclick="endPage()">尾页<i
										class="fa fa-angle-double-right"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="text" class="page-go" id="jumpInput"/>&nbsp;&nbsp;&nbsp;&nbsp;
									 <a onclick="jumpPage()">GO</a></div>
								<div style="width: 100px;height: 100px; margin: 0 auto;">
									<span>当前第{{ currPage }}页</span><br>
									<span>共{{ totalPage }}页</span><br>
									<span>共{{ totalCount }}条记录</span><br>
								</div>
								<p class='page-infomation'></p>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>