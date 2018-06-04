window.onload = function() {
	var url = window.location.href;
	staff_id = url.substring(url.indexOf("=") + 1);
	console.log(staff_id);
	get_staffDetails(staff_id);
	
}

function get_staffDetails(staff_id) {
	var url = "/eca/staff/staff_getStaffByStaffId?staff.staff_id="
			+ staff_id;
	get_staffDetails_Ajax(url, staff_id);
}
function get_staffDetails_Ajax(url, staff_id) {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var staff_info = xmlhttp.responseText;
			staff_info = JSON.parse(staff_info);
			console.log(staff_info);
			// 获取单选框元素
			// 性别
			var staff_sex = document.getElementsByName("sex_content");
			var sex_man = staff_sex[0];
			var sex_woman = staff_sex[1];
						
			// 遍历并插入input的value
			$.each(staff_info, function(key, value) {
				// 如果是性别
				if (key == "staff_sex") {
					if (value == "男") {
						sex_man.checked = true;
					} else {
						sex_woman.checked = true;
					}
				}
	
			$('input[name="staff.' + key + '"]').val(value);
			});
			$('#staff_status').val(staff_info.staff_status);
			$('#staff_eduBackground').val(staff_info.staff_eduBackground);
			$('#staff_department').val(staff_info.staff_department);
			
			//进入页面自动更新年龄,提交到后台

		}
	}

	xmlhttp.open("post", url, true);
	xmlhttp.send();
}

//改变性别方法
function changeSex_man(even) {
	var sex = document.getElementById("sex");
	sex.value = even.value;
	return sex.value;
}
function changeSex_woman(even) {
	var sex = document.getElementById("sex");
	sex.value = even.value;
	return sex.value;
}



// staffDetail.jsp中的修改人员
function staff_relive() {
	$
			.confirm({
				title : '修改!',
				content : '确定修改么!',
				buttons : {

					取消 : function() {
					},
					确定 : {
						action : function() {
							loadstaffDetail_staff_relive();
						}
					}
				}
			});
}
// 修改按钮执行事件
function loadstaffDetail_staff_relive() {
	
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	
	var staffDetails = document.getElementById("staffDetails");
	var formData = new FormData(staffDetails);
	xmlhttp.onreadystatechange = function() {
		console.log("c2");
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var result = xmlhttp.responseText;
			if (result == 'updateSuccess') {
				toastr.success('编辑成功！');
			} else {
				toastr.error('编辑失败！');
			}
			//刷新页面
			//get_staffDetails();
		}
	};
	xmlhttp.open("post",
			"/eca/staff/staff_updateStaff?staff.staff_id="
					+ staff_id, true);
	xmlhttp.send(formData);
}