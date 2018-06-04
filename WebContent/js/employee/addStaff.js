// addStaff新建人员
function staff_change() {
	var url = "/eca/staff/staff_saveStaff";
	$
			.confirm({
				title : '新建!',
				content : '确定新建么!',
				buttons : {

					取消 : function() {
						// here the button key 'hey' will be used as the text.
					},
					确定 : {
						action : function() {
							// 判断身份证是否为空
							var name = document
									.getElementsByName("staff.staff_name")[0].value;
							var department = document
									.getElementsByName("staff.staff_department")[0].value;
							var birthday = document
									.getElementsByName("staff.staff_birthday")[0].value;
							if (department == "" || name == "" || birthday == "") {
								toastr.error('姓名、部门、或者生日不能为空哦！');
								return false;
							}
							loadstaffDetail_staff_change(url);

						}
					}
				}
			});

}
// 警员基本信息表
function loadstaffDetail_staff_change(url) {

	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	var staffDetails = document.getElementById("staffDetails");

	var formData = new FormData(staffDetails);
	
	xmlhttp.open("post", url, true);
	// xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
	xmlhttp.send(formData);

	xmlhttp.onreadystatechange = function() {
		console.log("c2");
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log(xmlhttp.responseText);
			var id = xmlhttp.responseText;
			toastr.success("新建人员成功");
			window.location.href = '/eca/staff/staff_page_staffList';
		}
	};

}
