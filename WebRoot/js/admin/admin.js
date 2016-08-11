$(document).ready(function() {
	initUi();
	checkSignIn();
});

function initUi() {
	var addFirstCategoryWindow_offset = $('#addFirstCategoryWindow').offset();
	 $('#addFirstCategoryWindow').jqxWindow({
         position: { x: addFirstCategoryWindow_offset.left + 400, y: addFirstCategoryWindow_offset.top + 100} ,
         showCollapseButton: false, maxHeight: 400, maxWidth: 700, minHeight: 200, minWidth: 200, height: 100, width: 300,
         initContent: function () {
             $('#addFirstCategoryWindow').jqxWindow('focus');
         }
     });
	 
	 var choiceCategoryImgWindow_offset = $('#choiceCategoryImgWindow').offset();
	 $('#choiceCategoryImgWindow').jqxWindow({
         position: { x: choiceCategoryImgWindow_offset.left + 700, y: choiceCategoryImgWindow_offset.top + 150} ,
         showCollapseButton: false, maxHeight: 400, maxWidth: 700, minHeight: 200, minWidth: 200, height: 100, width: 300,
         initContent: function () {
             $('#choiceCategoryImgWindow').jqxWindow('focus');
         }
     });
	 
	$('#jqxTree').jqxTree({
		height : '100%'
	});
	$("#addFirstCategoryManager").jqxButton({width:120,height:30});
	$("#addFirstCategoryManager").on('click',showAddFirstCategory);
	$('#choiceFirstCategoryImg').jqxButton({width:'100%',height:20});
	$('#choiceFirstCategoryImg').on('click',showChoiceCategoryImg);
	$('#cancleAddFirstCategory').jqxButton({width:40,height:25});
	$('#cancleAddFirstCategory').on('click',function(){$('#addFirstCategoryWindow').jqxWindow('close');});
	$('#okAddFirstCategory').jqxButton({width:40,height:25});
	$('#okAddFirstCategory').on('click',newFirstCategory);
	
	$('#jqxTree').on('select', function(event) {
		hideAll();
		var args = event.args;
		var item = $('#jqxTree').jqxTree('getItem', args.element);
		hideAll();
		switch (item.id) {
		case ("updateUser"):
			$("#editUser").show();
			break;
		case ("firstcategorymanager"):
			$("#admin-right #firstCategoryManager").show();
			initFirstCategoryTable();
			break;
		}
	});
	$("#editUser-table-username").val(getCookie("username"));
}

//向数据库传输newFirstCategory
function newFirstCategory(){
	var name = $("#addFirstCategoryName").val();
	var imgid = $('#allreadyChoiceImg').attr("imgId");
	if(imgid!=undefined&name!=undefined){
		$.post(
			'/show-message/insertFirstCategory',
			{
				name:name,
				img:imgid
			},
			function(data){
				$('#addFirstCategoryWindow').jqxWindow('close');
				initFirstCategoryTable();
			}
		)
	}else{
		alert("没有选择图片或名称未填写！");
	}
	
}

//显示新增一级分类ui
function showAddFirstCategory(){
	$('#addFirstCategoryWindow').jqxWindow('open');
}

//显示选择分类图片的window
function showChoiceCategoryImg(){
	$('#choiceCategoryImgWindow').jqxWindow('open');
	$.post(
		'/show-message/selectAllCategoryImg',
		function(data){
			var categoryImgList = data;
			var html = "";
			for (var i = 0; i < categoryImgList.length; i++) {
				html += "<img imgId='"+categoryImgList[i].id+"' src='"+categoryImgList[i].src+"' onclick='cateImgChoice(this)'/>";
			}
			$('#choiceCategoryTable').html(html);
		}
	);
}

//在分类图片里选择图片，并设置到新增一级分类的img里
function cateImgChoice(obj){
	var imgId = $(obj).attr("imgId");
	var src = $(obj).attr("src");
	$('#allreadyChoiceImg').attr('imgId',imgId);
	$('#allreadyChoiceImg').attr('src',src);
	$('#choiceCategoryImgWindow').jqxWindow('close');
}


// 初始化一级分类管理table
function initFirstCategoryTable() {
	$
			.post(
					'/show-message/findFirstCategoryList',
					function(data) {
						var firstCategoryList = data;
						var html = "<table><tr><th>序号</th><th>ID</th><th>name</th><th>img</th><th>修改</th><th>删除</th></tr>";
						for (var i = 0; i < firstCategoryList.length; i++) {
							var firstCategory = firstCategoryList[i];
							html += "<tr firstCategoryId='"
									+ firstCategory.id
									+ "'><td>"
									+ (i + 1)
									+ "</td><td>"
									+ firstCategory.id
									+ "</td><td>"
									+ firstCategory.name
									+ "</td><td>"
									+ firstCategory.img
									+ "</td><td>修改</td><td onclick='deleteFirstCategory(this)'>删除</td></tr>";
						}
						html += "</table>";
						$("#admin-right #firstCategoryTable").html(html);
					});
}

// 删除一级分类
function deleteFirstCategory(obj) {
	var tr = getRowObj(obj);
	var firstCategoryId = $(tr).attr("firstCategoryId");
}

function checkSignIn() {
	var username = getCookie("username");
	if (username == null) {
		window.self.location = "/show-message/login";
	} else {
		$("#username-value").html(username);
	}

}

function updateUser() {
	var name = getCookie("username");
	var passwordOld = $("#password-old").val();
	var passwordNew1 = $("#password-new1").val();
	var passwordNew2 = $("#password-new2").val();
	if (passwordOld == "") {
		alert("请输入原密码");
	} else {
		if (passwordNew1 == passwordNew2) {
			$.post('/show-message/updateUser', {
				name : name,
				password : passwordOld + "," + passwordNew1
			}, function(data) {
				if (data == "") {
					alert("修改失败");
				} else {
					alert("修改成功");
				}
			});
		} else {
			alert("两次输入的新密码不一致");
		}
	}
}

function hideAll() {
	$("#editUser").hide();
	$("#admin-right #firstCategoryManager").hide();
}

// Cookies操作
function setCookie(name, value) {
	var Days = 30; // 此 cookie 将被保存 30 天
	var exp = new Date(); // new Date("December 31, 9998");
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	document.cookie = name + "=" + escape(value) + ";expires="
			+ exp.toGMTString();
}
function getCookie(name) {
	var arr = document.cookie
			.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if (arr != null)
		return unescape(arr[2]);
	return null;
}
function delCookie(name) {
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	if (cval != null)
		document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

// 得到行对象
function getRowObj(obj) {
	var i = 0;
	while (obj.tagName.toLowerCase() != "tr") {
		obj = obj.parentNode;
		if (obj.tagName.toLowerCase() == "table")
			return null;
	}
	return obj;
}
