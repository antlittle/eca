/**
 * 
 */
var allPageVue;
var queryConditionTemp = {
	"currPage" : "1",
	"totalPage" : "",
	"pageCount" : "10",
	"totalCount" : "",
	"staffJoinTime" : "desc",
	"staffName" : "",
	"staffSex" : "",
	"staffStatus" : ""
}
window.onload = function() {
	allPageVue = new Vue({
		el : '#allPage',
		data : {
			currPage : '1',
			totalPage : '',
			pageCount : '10',
			totalCount : '',
			staffs : ''
		}
	});
	loadData();
}

var changeSort = function(event) {
	queryConditionTemp.staffJoinTime = event.value;
	queryConditionTemp.currPage = "1";
	loadData();
}

var changeStatus = function(event) {
	queryConditionTemp.staffStatus = event.value;
	queryConditionTemp.currPage = "1";
	loadData();
}
var changeSex = function(event) {
	queryConditionTemp.staffSex = event.value;
	queryConditionTemp.currPage = "1";
	loadData();
}
var changeName = function(event) {
	queryConditionTemp.staffName = event.value;
	queryConditionTemp.currPage = "1";
	loadData();
}
var firstPage = function() {
	if (queryConditionTemp.currPage <= 1) {
		toastr.error("已经是第一页");
	} else {
		queryConditionTemp.currPage = '1';
		loadData();
	}
}
var prePage = function() {
	if (queryConditionTemp.currPage <= 1) {
		toastr.error("没有上一页了哦");
	} else {
		queryConditionTemp.currPage = --queryConditionTemp.currPage;
		loadData();
	}
}

var nextPage = function() {
	if (queryConditionTemp.currPage >= queryConditionTemp.totalPage) {
		toastr.error("没有下一页了哦");
	} else {
		queryConditionTemp.currPage = ++queryConditionTemp.currPage;
		loadData();
	}
}

var endPage = function() {
	if (queryConditionTemp.currPage >= queryConditionTemp.totalPage) {
		toastr.error("已经是最后一页");
	} else {
		queryConditionTemp.currPage = queryConditionTemp.totalPage;
		loadData();
	}
}

var jumpPage = function() {
	if ($('#jumpInput').val() <= queryConditionTemp.totalPage
			&& $('#jumpInput').val() >= 1) {
		queryConditionTemp.currPage = $('#jumpInput').val()
		loadData();
	} else {
		toastr.error("不存在这一页");
	}
}

var createConfirm = function(event) {
	$.confirm({
		title : '真的要删除吗？',
		content : '',
		type : 'red',
		autoClose : 'closeAction|5000',
		buttons : {
			deleteAction : {
				text : '确认',
				btnClass : 'btn-blue',
				action : function() {
					deletePoliceman(event);
					loadData();
				}
			},
			closeAction : {
				text : '取消',
				btnClass : 'btn-red',
				action : function() {

				}
			}
		}
	})
}
function  createConfirm_relive(event) {
	console.log("进入修改");
	enterRelivePage(event);
}
function enterRelivePage(event){
	window.location = "/xsjsglxt/team/Staff_intoUpdate?xsjsglxt_staff_id="
		+ event.id;
}
var deletePoliceman = function(event) {
	// 此处调用九个接口
	// 删除警员基本信息
	$.ajax({
		url : '/xsjsglxt/team/Staff_deletePoliceman',
		type : 'POST',
		data : {
			'policeman.xsjsglxt_staff_id' : event.id
		}
	});
	$.ajax({
		url : '/xsjsglxt/team/StaffFamily_deleteFamilyByStaffId',
		type : 'POST',
		data : {
			'family.staffFamily_staff' : event.id
		}
	});
	$.ajax({
		url : '/xsjsglxt/team/StaffFurlough_deleteFurloughByStaffId',
		type : 'POST',
		data : {
			'furlough.staffFurlough_staff' : event.id
		}
	});
	$.ajax({
		url : '/xsjsglxt/team/StaffMove_deleteMoves',
		type : 'POST',
		data : {
			'move.staffMove_staff' : event.id
		}
	});
	$.ajax({
		url : '/xsjsglxt/team/StaffPrinciple_deletePrinciples',
		type : 'POST',
		data : {
			'principle.staffPrinciple_staff' : event.id
		}
	});
	$.ajax({
		url : '/xsjsglxt/team/StaffPunishment_deletePunishments',
		type : 'POST',
		data : {
			'punishment.staffPunishment_staff' : event.id
		}
	});
	$.ajax({
		url : '/xsjsglxt/team/StaffReward_deleteRewards',
		type : 'POST',
		data : {
			'reward.staffReward_staff' : event.id
		}
	});
	$.ajax({
		url : '/xsjsglxt/team/StaffStudent_deleteStudents',
		type : 'POST',
		data : {
			'student.staffStudent_staff' : event.id
		}
	});
	$.ajax({
		url : '/xsjsglxt/team/StaffWork_deleteWorks',
		type : 'POST',
		data : {
			'work.staffWork_staff' : event.id
		}
	});
}
var skipToDetails = function(event) {
	window.location = "/xsjsglxt/team/Staff_page_staffDetails?xsjsglxt_staff_id="
			+ event.id;
}

var loadData = function() {
	$('#mainPanel').hide();
	$('#loadingLayer').show();
	alert(queryConditionTemp.staffStatus);
	var queryCondition = {
		"staffVO.currPage" : queryConditionTemp.currPage,
		"staffVO.totalPage" : queryConditionTemp.totalPage,
		"staffVO.pageCount" : queryConditionTemp.pageCount,
		"staffVO.totalCount" : queryConditionTemp.totalCount,
		"staffVO.staffJoinTime" : queryConditionTemp.staffJoinTime,
		"staffVO.staffName" : queryConditionTemp.staffName,
		"staffVO.staffSex" : queryConditionTemp.staffSex,
		"staffVO.staffStatus" : queryConditionTemp.staffStatus,
	}
	$.ajax({
		url : '/eca/staff/staff_getStaffsByPage',
		type : 'POST',
		data : queryCondition,
		success : function(data) {
			alert(data);
			var result = JSON.parse(data);
			allPageVue.staffs = result.staffs;
			allPageVue.currPage = result.currPage;
			allPageVue.totalPage = result.totalPage;
			allPageVue.pageCount = result.pageCount;
			allPageVue.totalCount = result.totalCount;
			queryConditionTemp.currPage = result.currPage;
			queryConditionTemp.totalPage = result.totalPage;
			queryConditionTemp.pageCount = result.pageCount;
			queryConditionTemp.totalCount = result.totalCount;
			queryConditionTemp.staffJoinTime = result.staffJoinTime;
			queryConditionTemp.staffName = result.staffName;
			queryConditionTemp.staffSex = result.staffSex;
			queryConditionTemp.staffStatus = result.staffStatus;
			$('#loadingLayer').hide();
			$('#mainPanel').show();
		}
	});
}