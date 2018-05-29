<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统首页</title>
</head>
<body>
		<div id="wrapper">
		<s:action name="user_implements_navbar" namespace="/user" executeResult="true" />
		
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar"
			style="width: 200px; height: 100% !important; background-color: #202a45;">
			<div class="sidebar-scroll" style="height: 100% !important;">
				<nav>
				<ul class="nav">
					<li><a class=""><i class="lnr lnr-file-add"></i> <span>信息查询</span></a>
						<ul class="nav" style="background-color: #202a45;">
							<li><a href="#href"><span>考勤概况</span></a></li>
							<li><a href="#href"><span>部门概况</span></a></li>
							<li><a href="#href"><span>个人信息</span></a></li>
						</ul>
					<li><a class=""><i class="lnr lnr-license"></i> <span>事假中心</span></a>
						<ul class="nav" style="background-color: #202a45;">
<!-- 							<template v-if="user_technology_manager_power"> -->
							<li><a href="#href"><span>申请事假</span></a></li>
							<li><a href="#href"><span>事假处理</span></a></li>
<!-- 							</template> -->
<!-- 							<template v-if="user_technology_manager_power"> -->
							<li><a
								href="#href"><span></span></a></li>
<!-- 							</template> -->
						</ul></li>	
					<li><a class=""><i class="lnr lnr-users"></i> <span>企业管理</span></a>
						<ul class="nav" style="background-color: #202a45;">
	
							<li><a href="<%=basePath%>staff/staff_page_staffList"><span>人员管理</span></a></li>
	
	
							<li><a href="#href"><span>部门管理</span></a></li>
					
	
							<li><a href="#href"><span>企业公告</span></a></li>

						</ul></li>
				</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
			<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content"  >
				<div class="container"  >
					<!-- OVERVIEW -->
					<div class="panel panel-headline" >
						<div class="panel-body" style="height:550px">
						<button class="btn btn-lg btn-primary" style="float:right; margin-top:18px; margin-right:30px;"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;立即签到</button>
						<h2>欢迎您, <B><%=request.getSession().getAttribute("user_name")%> !</B></h2>	
						<hr>
						</div>
						
					</div>
					<!-- END OVERVIEW -->
				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END MAIN -->
	</div>	
</body>
</html>