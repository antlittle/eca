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
<!---------------------------------------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------->
<title>人员详情信息</title>
<link rel="stylesheet" href="<%=basePath%>css/employee/table.css">
<link rel="stylesheet" href="<%=basePath%>css/employee/Team.css">
</head>

<body>
<s:action name="user_implements_navbar" namespace="/user" executeResult="true" />
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div
		style="margin: 80px 0 0 0; float: left; width: 100%; overflow: hidden;">
		<div class="panel"
			style="width: 1100px; margin: 20px auto; overflow: inherit; position: relative;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">新建人员</h3>
			</div>
			<div style="margin-left: 5%;">
				<button onclick="javascript:history.go(-1)" type="button"
					class="btn btn-default button button_return ">
					<i class="fa fa-reply"></i> 返回列表
				</button>
			</div>
			<div class="panel-body staff_body">
				<div style="width: 1000px; margin: 0 auto;">
					<form id="staffDetails" enctype="multipart/form-data"
						accept-charset="utf-8">
						<table  class="table table-bordered " style="width: 100%;">
							<tr>
								<td colspan="6" class="staff_info_title info">基本信息</td>
							</tr>
							<tr style="height: 20px"></tr>
							<tr>
								<td><label class="staff_info_label">姓名</label></td>
								<td><input name="staff.staff_name"
									class="form-control" type="text"></td>
								<td><label class="staff_info_label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label></td>
								<td><label style="float: left; width: 50px;"
									class="fancy-radio person_radio"> <input
										name="staff.staff_sex" type="radio" value="男">
										<span> <i></i>男
									</span>
								</label> <label style="float: left; width: 50px; margin-left: 10px;"
									class="fancy-radio "> <input
										name="staff.staff_sex" type="radio" value="女">
										<span><i></i>女</span>
								</label></td>
							</tr>
							<tr>

								<td><label class="staff_info_label">最高学历</label></td>
								<td><select class="form-control"
									name="staff.staff_eduBackground">
										<option></option>
										<option>高中</option>
										<option>专科</option>
										<option>本科</option>
										<option>研究生</option>
										<option>博士</option>
								</select></td>
								<td><label class="staff_info_label">职位</label></td>
								<td><select class="form-control"
									name="staff.staff_status">
										<option></option>
										<option>总经理</option>
										<option>部门经理</option>
										<option>部门主管</option>
										<option>职员</option>
								</select></td>


							</tr>
							<tr>
							<td><label class="staff_info_label">部门</label></td>
								<td><select class="form-control"
									name="staff.staff_department"
									onchange="checkUp(this.value)">
										<option></option>
										<option>销售部</option>
										<option>业务部</option>
										<option>财务部</option>
										<option>人事部</option>
										<option>行政部</option>
								</select></td>
								<td><label class="staff_info_label">生日</label></td>
								<td><input name="staff.staff_birthday"
									class="form-control staff_birthday" type="text"></td>
							</tr>
							<tr>
								<td colspan="6" class="staff_info_title info">联系方法</td>
							</tr>
							<tr style="height: 20px;"></tr>
							<tr>
								<td><label class="staff_info_label">手机号</label></td>
								<td><input name="staff.staff_phone"
									class="form-control" style="margin-top: 6px;" type="text"></td>
							<tr>

								<td><label class="staff_info_label">家庭地址</label></td>
								<td colspan="3"><input name="staff.staff_address"
									style="width: 590px;" class="form-control" type="text"></td>
							</tr>

						</table>
						<br>
								<button style="float: right;" type="button"
								class="btn btn-default button" onclick="staff_change()">
								<i class="fa fa-pencil"></i> 保存
								</button>
					</form>
				</div>
<!-- 				<div class="longBoxs"> -->
<!-- 					<div class="long_tableBox"> -->
<%-- 						<span class="staff_info_title">学习/出差经历</span> --%>
<!-- 						<button style="margin-left: 10px;" class="btn btn-default btn-xs" -->
<!-- 							type="button" data-toggle="modal" data-target="#addStudy_Modal" -->
<!-- 							onclick=""> -->
<!-- 							<i class="fa fa-plus-square"></i> 添加 -->
<!-- 						</button> -->

<!-- 						<form id="study_exp"> -->
<!-- 							<div class="long_tb"> -->
<!-- 								<table id="studyExperience_table"> -->
<!-- 									<tbody> -->
<!-- 										<tr class="long_table"> -->
<!-- 											<th>类别</th> -->
<!-- 											<th>地点</th> -->
<!-- 											<th>起始时间</th> -->
<!-- 											<th>结束时间</th> -->
<!-- 											<th>备注</th> -->
<!-- 											<th>操作</th> -->
<!-- 										</tr> -->

<!-- 									</tbody> -->
<!-- 								</table> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 					</div> -->
<!-- 					<div style="background: #e7e6e6; width: 1000px; height: 1px;"></div> -->
<!-- 					<div class="long_tableBox"> -->
<%-- 						<span class="staff_info_title">工作经历</span> --%>
<!-- 						<button style="margin-left: 10px;" class="btn btn-default btn-xs" -->
<!-- 							type="button" data-toggle="modal" data-target="#addWork_Modal" -->
<!-- 							onclick=""> -->
<!-- 							<i class="fa fa-plus-square"></i> 添加 -->
<!-- 						</button> -->
<!-- 						<form id="work_exp"> -->
<!-- 							<div class="long_tb"> -->
<!-- 								<table id="wordExperience_table"> -->
<!-- 									<tbody> -->
<!-- 										<tr class="long_table"> -->
<!-- 											<th>工作地点</th> -->
<!-- 											<th>职务</th> -->
<!-- 											<th>起始时间</th> -->
<!-- 											<th>结束时间</th> -->
<!-- 											<th>备注</th> -->
<!-- 											<th>操作</th> -->
<!-- 										</tr> -->
<!-- 									</tbody> -->
<!-- 								</table> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 					</div> -->
<!-- 					<div style="background: #e7e6e6; width: 1000px; height: 1px;"></div> -->
<!-- 					<div class="long_tableBox"> -->
<%-- 						<span class="staff_info_title">家庭情况</span> --%>
<!-- 						<button style="margin-left: 10px;" class="btn btn-default btn-xs" -->
<!-- 							type="button" data-toggle="modal" data-target="#addFamily_Modal" -->
<!-- 							onclick=""> -->
<!-- 							<i class="fa fa-plus-square"></i> 添加 -->
<!-- 						</button> -->
<!-- 						<div class="long_tb"> -->
<!-- 							<table id="family_table" style="width: 150%;"> -->

<!-- 								<tbody> -->
<!-- 									<tr class="long_table"> -->
<!-- 										<th>关系</th> -->
<!-- 										<th>姓名</th> -->
<!-- 										<th>身份证号</th> -->
<!-- 										<th>生日</th> -->
<!-- 										<th>手机号</th> -->
<!-- 										<th>微信号</th> -->
<!-- 										<th>工作单位</th> -->
<!-- 										<th>职位</th> -->
<!-- 										<th colspan="2">备注</th> -->
<!-- 										<th>操作</th> -->
<!-- 									</tr> -->
<!-- 								</tbody> -->

<!-- 							</table> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div style="background: #e7e6e6; width: 1000px; height: 1px;"></div> -->
<!-- 					<div class="long_tableBox"> -->
<%-- 						<span class="staff_info_title">工作调动情况</span> --%>
<!-- 						<button style="margin-left: 10px;" class="btn btn-default btn-xs" -->
<!-- 							type="button" data-toggle="modal" -->
<!-- 							data-target="#addPoliceChange_Modal" onclick=""> -->
<!-- 							<i class="fa fa-plus-square"></i> 添加 -->
<!-- 						</button> -->
<!-- 						<form id="police_move"> -->
<!-- 							<div class="long_tb"> -->
<!-- 								<table id="policeChange_table"> -->
<!-- 									<tbody> -->
<!-- 										<tr class="long_table"> -->
<!-- 											<th>调入时间</th> -->
<!-- 											<th>调出时间</th> -->
<!-- 											<th>是否在岗</th> -->
<!-- 											<th>备注</th> -->
<!-- 											<th>操作</th> -->
<!-- 										</tr> -->
<!-- 									</tbody> -->
<!-- 								</table> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 					</div> -->
<!-- 					<div style="background: #e7e6e6; width: 1000px; height: 1px;"></div> -->
<!-- 					<div class="long_tableBox"> -->
<%-- 						<span class="staff_info_title">立功受奖情况</span> --%>
<!-- 						<button style="margin-left: 10px;" class="btn btn-default btn-xs" -->
<!-- 							type="button" data-toggle="modal" data-target="#addPrized_Modal" -->
<!-- 							onclick=""> -->
<!-- 							<i class="fa fa-plus-square"></i> 添加 -->
<!-- 						</button> -->
<!-- 						<form id="staffReward"> -->
<!-- 							<div class="long_tb"> -->
<!-- 								<table id="prized_table"> -->
<!-- 									<tbody> -->
<!-- 										<tr class="long_table"> -->
<!-- 											<th>表彰情况</th> -->
<!-- 											<th>表彰时间</th> -->
<!-- 											<th>备注</th> -->
<!-- 											<th>操作</th> -->
<!-- 										</tr> -->
<!-- 									</tbody> -->
<!-- 								</table> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 					</div> -->
<!-- 					<div style="background: #e7e6e6; width: 1000px; height: 1px;"></div> -->
<!-- 					<div class="long_tableBox"> -->
<%-- 						<span class="staff_info_title">违纪处分情况</span> --%>
<!-- 						<button style="margin-left: 10px;" class="btn btn-default btn-xs" -->
<!-- 							type="button" data-toggle="modal" -->
<!-- 							data-target="#addAgainstPrinciple_Modal" onclick=""> -->
<!-- 							<i class="fa fa-plus-square"></i> 添加 -->
<!-- 						</button> -->
<!-- 						<form id="againstPrinciple"> -->
<!-- 							<div class="long_tb"> -->
<!-- 								<table id="againstPrinciple_table"> -->
<!-- 									<tbody> -->
<!-- 										<tr class="long_table"> -->
<!-- 											<th>违纪情况</th> -->
<!-- 											<th>违纪时间</th> -->
<!-- 											<th>备注</th> -->
<!-- 											<th>操作</th> -->
<!-- 										</tr> -->
<!-- 									</tbody> -->
<!-- 								</table> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 					</div> -->
<!-- 					<div style="background: #e7e6e6; width: 1000px; height: 1px;"></div> -->
<!-- 					<div class="long_tableBox"> -->
<%-- 						<span class="staff_info_title">请休假情况</span> --%>
<!-- 						<button style="margin-left: 10px;" class="btn btn-default btn-xs" -->
<!-- 							type="button" data-toggle="modal" -->
<!-- 							data-target="#addVocation_Modal" onclick=""> -->
<!-- 							<i class="fa fa-plus-square"></i> 添加 -->
<!-- 						</button> -->
<!-- 						<form id="Furlough"> -->
<!-- 							<div class="long_tb"> -->
<!-- 								<table id="vocation_table"> -->
<!-- 									<tbody> -->
<!-- 										<tr class="long_table"> -->
<!-- 											<th>起始时间</th> -->
<!-- 											<th>销假时间</th> -->
<!-- 											<th>是否销假</th> -->
<!-- 											<th>请休假事由</th> -->
<!-- 											<th>天数</th> -->
<!-- 											<th>备注</th> -->
<!-- 											<th>操作</th> -->
<!-- 										</tr> -->
<!-- 									</tbody> -->
<!-- 								</table> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="<%=basePath%>js/employee/addStaff.js"></script>
	<script type="text/javascript">
	$.datetimepicker.setLocale('ch');
	$('.staff_birthday').datetimepicker({
		yearStart : 1900, // 设置最小年份
		yearEnd : 2100, // 设置最大年份
		yearOffset : 0, // 年偏差
		timepicker : false, // 关闭时间选项
		format : 'Y-m-d', // 格式化日期年-月-日
		minDate : '1900/01/01', // 设置最小日期
		maxDate : '2100/01/01', // 设置最大日期
	});
	</script>
</body>
</html>