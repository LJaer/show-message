var pageFlag = 1;// 记录是否已经初始化pagenav

$(document).ready(function() {
	initUi();
	checkSignIn();
});

function initUi() {
	var addFirstCategoryWindow_offset = $('#addFirstCategoryWindow').offset();
	$('#addFirstCategoryWindow').jqxWindow({
		position : {
			x : addFirstCategoryWindow_offset.left + 400,
			y : addFirstCategoryWindow_offset.top + 100
		},
		showCollapseButton : false,
		maxHeight : 400,
		maxWidth : 700,
		minHeight : 200,
		minWidth : 200,
		height : 100,
		width : 300,
		initContent : function() {
			$('#addFirstCategoryWindow').jqxWindow('focus');
		}
	});

	var choiceCategoryImgWindow_offset = $('#choiceCategoryImgWindow').offset();
	$('#choiceCategoryImgWindow').jqxWindow({
		position : {
			x : choiceCategoryImgWindow_offset.left + 700,
			y : choiceCategoryImgWindow_offset.top + 150
		},
		showCollapseButton : false,
		maxHeight : 400,
		maxWidth : 700,
		minHeight : 200,
		minWidth : 200,
		height : 100,
		width : 300,
		initContent : function() {
			$('#choiceCategoryImgWindow').jqxWindow('focus');
		}
	});

	// updateSecondCategoryWindow
	var updateSecondCategoryWindow_offset = $('#updateSecondCategoryWindow')
			.offset();
	$('#updateSecondCategoryWindow').jqxWindow({
		position : {
			x : updateSecondCategoryWindow_offset.left + 300,
			y : updateSecondCategoryWindow_offset.top + 150
		},
		showCollapseButton : false,
		maxHeight : 400,
		maxWidth : 700,
		minHeight : 200,
		minWidth : 200,
		height : 100,
		width : 300,
		initContent : function() {
			$('#updateSecondCategoryWindow').jqxWindow('focus');
		}
	});

	// /editFirstCategoryWindow
	var editFirstCategoryWindow_offset = $('#editFirstCategoryWindow').offset();
	$('#editFirstCategoryWindow').jqxWindow({
		position : {
			x : editFirstCategoryWindow_offset.left + 300,
			y : editFirstCategoryWindow_offset.top + 150
		},
		showCollapseButton : false,
		maxHeight : 400,
		maxWidth : 700,
		minHeight : 200,
		minWidth : 200,
		height : 100,
		width : 300,
		initContent : function() {
			$('#editFirstCategoryWindow').jqxWindow('focus');
		}
	});

	// addSecondCategoryWindow
	var addSecondCategoryWindow_offset = $('#addSecondCategoryWindow').offset();
	$('#addSecondCategoryWindow').jqxWindow({
		position : {
			x : addSecondCategoryWindow_offset.left + 300,
			y : addSecondCategoryWindow_offset.top + 150
		},
		showCollapseButton : false,
		maxHeight : 400,
		maxWidth : 700,
		minHeight : 200,
		minWidth : 200,
		height : 100,
		width : 300,
		initContent : function() {
			$('#addSecondCategoryWindow').jqxWindow('focus');
		}
	});

	// addCategoryImgWindow
	var addCategoryImgWindow_offset = $('#addCategoryImgWindow').offset();
	$('#addCategoryImgWindow').jqxWindow({
		position : {
			x : addCategoryImgWindow_offset.left + 300,
			y : addCategoryImgWindow_offset.top + 150
		},
		showCollapseButton : false,
		maxHeight : 400,
		maxWidth : 700,
		minHeight : 200,
		minWidth : 200,
		height : 100,
		width : 300,
		initContent : function() {
			$('#addCategoryImgWindow').jqxWindow('focus');
		}
	});
	
	//showAddPictureWindow
	var showAddPictureWindow_offset = $('#showAddPictureWindow').offset();
	$('#showAddPictureWindow').jqxWindow({
		position : {
			x : showAddPictureWindow_offset.left + 300,
			y : showAddPictureWindow_offset.top + 150
		},
		showCollapseButton : false,
		maxHeight : 200,
		maxWidth : 300,
		minHeight : 200,
		minWidth : 200,
		height : 100,
		width : 300,
		initContent : function() {
			$('#showAddPictureWindow').jqxWindow('focus');
		}
	});

	$('#jqxTree').jqxTree({
		height : '100%'
	});
	$("#addFirstCategoryManager").jqxButton({
		width : 120,
		height : 30
	});
	$("#addFirstCategoryManager").on('click', showAddFirstCategory);
	$('#choiceFirstCategoryImg').jqxButton({
		width : '100%',
		height : 20
	});
	$('#choiceFirstCategoryImg').on('click', showChoiceCategoryImg);
	$('#cancleAddFirstCategory').jqxButton({
		width : 40,
		height : 25
	});
	$('#cancleAddFirstCategory').on('click', function() {
		$('#addFirstCategoryWindow').jqxWindow('close');
	});
	$('#okAddFirstCategory').jqxButton({
		width : 40,
		height : 25
	});
	$('#okAddFirstCategory').on('click', newFirstCategory);
	$('#cancleAddSecondCategory').jqxButton({
		width : 40,
		height : 25
	});
	$('#cancleAddSecondCategory').on('click', function() {
		$("#addSecondCategoryWindow").jqxWindow('close')
	});
	$('#okAddSecondCategory').jqxButton({
		width : 40,
		height : 25
	});
	$('#okAddSecondCategory').on('click', newSecondCategory);
	$('#addSecondCategory').jqxButton({
		width : 100,
		height : 25
	});
	$('#addSecondCategory').on('click', function() {
		$("#addSecondCategoryWindow").jqxWindow('open')
	});
	// cancleUpdateSecondCategory
	$('#cancleUpdateSecondCategory').jqxButton({
		width : 100,
		height : 25
	});
	$('#cancleUpdateSecondCategory').on('click', function() {
		$("#updateSecondCategoryWindow").jqxWindow('close')
	});
	// okUpdateSecondCategory
	$('#okUpdateSecondCategory').jqxButton({
		width : 100,
		height : 25
	});
	$('#okUpdateSecondCategory').on('click', updateSecondCategory);
	// cancleUpdateArticle
	$('#cancleUpdateArticle').jqxButton({
		width : 100,
		height : 25
	});
	$('#cancleUpdateArticle').on('click', cancleUpdateArticle);
	// articleManager-addArticle
	$('#articleManager-addArticle').jqxButton({
		width : 100,
		height : 25
	});
	$('#articleManager-addArticle').on('click', showAddArticle);

	// cancleAddArticle
	$('#cancleAddArticle').jqxButton({
		width : 100,
		height : 25
	});
	$('#cancleAddArticle').on('click', hideAddArticle);
	// signout
	$('#signout').jqxButton({
		width : 50,
		height : 20
	});
	$('#signout').on('click', signout);
	// addArticle-button
	$('#addArticle-button').jqxButton({
		width : 50,
		height : 25
	});
	$('#addArticle-button').on('click', addArticle);
	// updateArticle-button
	$('#updateArticle-button').jqxButton({
		width : 100,
		height : 25
	});
	$('#updateArticle-button').on('click', updateArticle);
	$('#addCategoryImg').jqxButton({
		width : 100,
		height : 25
	});
	$('#addCategoryImg').on('click', addCategoryImg);
	$('#addShowPicture').jqxButton({
		width : 100,
		height : 25
	});
	$('#addShowPicture').on('click', showAddPictureWindow);

	$('#jqxTree').on('select', function(event) {
		hideAll();
		var args = event.args;
		var item = $('#jqxTree').jqxTree('getItem', args.element);
		switch (item.id) {
		case ("updateUser"):
			$("#editUser").show();
			break;
		case ("firstcategorymanager"):
			$("#admin-right #firstCategoryManager").show();
			initFirstCategoryTable();
			break;
		case ("secondcategorymanager"):
			$("#admin-right #secondCategoryManager").show();
			initSecondCategoryManager();
			break;
		case ("articlemanager"):
			$("#admin-right-articlemanager").show();
			initArticleManage();
			break;
		case ("categoryImgmanager"):
			$("#categoryImgManage").show();
			initCategoryImgManager();
			break;
		case ("showimgmanager"):
			$("#imgmanager").show();
			initImgManager();
			break;
		}
	});
	$("#editUser-table-username").val(getCookie("username"));
}

//上传展示图片
function uploadFileAddShowPicture(){
	var fileObj = document.getElementById("upload-file-showpictures").files[0]; // 获取文件对象
	var FileController = "/show-message/insertShowPicture"; // 接收上传文件的后台地址

	if (fileObj) {
		// FormData 对象
		var form = new FormData();
		form.append("file", fileObj);// 文件对象

		// XMLHttpRequest 对象
		var xhr = new XMLHttpRequest();
		xhr.open("post", FileController, true);
		xhr.onload = function() {
			alert(xhr.responseText);
			initImgManager();
		};
		xhr.send(form);
	} else {
		alert("未选择文件");
	}
}

//显示新增图片窗口
function showAddPictureWindow(){
	$("#showAddPictureWindow").show();
}

//初始化图片管理
function initImgManager(){
	$.post(
		'/show-message/queryAllPictures',
		function(data){
			var imgList = data;
			var html = "<table id='imgmanager-table-in'><tr><th>序号</th><th>id</th><th>name</th><th>是否选择</th><th>图片</th><th>修改状态</th><th>删除</th></tr>";
			for (var i = 0; i < imgList.length; i++) {
				var img = imgList[i];
				html += "<tr><td>"+(i+1)+"</td><td>"+img.id+"</td><td>"+img.name+"</td><td>";
				if(img.choice==1){
					html += "已选择";
				}else{
					html += "未选择";
				}
				html += "</td><td><img class='imgManager-picture' src='/show-message/pictures/showImg/"+img.name+"'></td><td onclick='changeShowPictureChoice("+img.id+","+img.choice+")'>修改状态</td><td onclick='delShowPicture("+img.id+")'>删除</td></tr>";
			}
			html += "</table>";
			$("#imgmanager-table").html(html);
		}
	);
}

//改变展示图片选择状态
function changeShowPictureChoice(id,choice){
	switch(choice){
	case null:
		choice = 1;
		break;
	case 1:
		choice = 0;
		break;
	case 0:
		choice = 1;
		break;
	}
	$.post(
		'/show-message/changeChoice',
		{
			id:id,
			choice:choice
		},
		function(data){
			if(data>0){
				initImgManager();
				alert(" 更新成功"+data+"条");
			}
			
		}
	);
}

//删除展示图片
function delShowPicture(id){
	$.post(
		'/show-message/delPicture',
		{
			id:id
		},
		function(data){
			alert("删除成功："+data+"条");
			if(data>0){
				initImgManager();
			}
		}
	);
}

// addCategoryImg
function addCategoryImg() {
	$('#addCategoryImgWindow').jqxWindow('open');
}

// 上传分类图片
function uploadFileAddCategoryImg() {
	var fileObj = document.getElementById("upload-file-categoryImg").files[0]; // 获取文件对象
	var FileController = "/show-message/insertCategoryImg"; // 接收上传文件的后台地址

	if (fileObj) {
		// FormData 对象
		var form = new FormData();
		form.append("file", fileObj);// 文件对象

		// XMLHttpRequest 对象
		var xhr = new XMLHttpRequest();
		xhr.open("post", FileController, true);
		xhr.onload = function() {
			alert(xhr.responseText);
			initCategoryImgManager();
		};
		xhr.send(form);
		
	} else {
		alert("未选择文件");
	}
}

// updateArticle
function updateArticle() {
	var articleId = $("#updateArticle-articleId").html();
	var name = $("#updateArticle-articleName").val();
	var editor = UE.getEditor('updateArticle-articleContent');
	var html = editor.getContent();
	var cs;
	$.post('/show-message/updateArticleSelective', {
		id : articleId,
		name : name,
		html : html
	}, function(data) {
		if (data != 0) {
			alert("更新成功");
			$("#updateArticle").hide();
			$("#articlemanager-articlelist").show();
			$("#articleManager-addArticle").show();
			pageFlag = 1;
			showArticleManagerArticleList();
		} else {
			alert("更新失败!");
		}
	});

}

// signout
function signout() {
	delCookie("username");
	window.self.location = "/show-message/login";
}

// 初始化分页功能
function initPageNav(page, pageTotal) {
	// pageNav
	// optional set
	pageNav.pre = "上一页";
	pageNav.next = "下一页";
	// goto the page 3 of 33.
	if (pageFlag == 1) {
		pageNav.go(1, pageTotal);
		pageFlag++;
	}
	// p:current page number.
	// pn: page sum.
	pageNav.fn = function(page, pageTotal) {
		showArticleManagerArticleList(page);
		// $("#test").text("Page:"+p+" of "+pn + " pages."); //for jquery
	};
}

// cancleUpdateArticle
function cancleUpdateArticle() {
	$("#updateArticle").hide();
	$("#articlemanager-articlelist").show();
	$("#articleManager-addArticle").show();
	$("#pageNav").show();
}

// addArticle
function addArticle() {
	var select = document.getElementById("articlemanager-secondcategorylist");
	var index = select.selectedIndex;
	var secondCategoryId = select.options[index]
			.getAttribute("secondcategoryid");
	var name = $('#addArticle-articleName').val();
	var editor = UE.getEditor('addArticle-articleContent');
	var html = editor.getContent();
	$.post('/show-message/insertArticle', {
		name : name,
		html : html,
		secondcategoryid : secondCategoryId
	}, function(data) {
		if (data != 0) {
			alert("增加成功");
			$("#articlemanager-articlelist").show();
			$("#addArticle").hide();
			showArticleManagerArticleList();
		} else {
			alert("增加失败");
		}
		pageFlag = 1;
	});
}

// 初始化文章管理
function initArticleManage() {
	$("#articlemanager-articlelist").html("");
	$("#pageNav").hide();
	$("#articlemanager-secondcategorylist").hide();
	// 初始化一级下拉列表
	$.post('/show-message/findFirstCategoryList', function(data) {
		var firstCategoryList = data;
		var html = "<option>未选择</option>";
		for (var i = 0; i < firstCategoryList.length; i++) {
			html += "<option firstcategoryid='" + firstCategoryList[i].id
					+ "'>" + firstCategoryList[i].name + "</option>";
		}
		$("#articlemanager-firstcategorylist").html(html);
	});
}

// 初始化图标管理
function initCategoryImgManager() {
	$
			.post(
					'/show-message/selectAllCategoryImg',
					function(data) {
						// categoryImgManage_table
						var categoryImgList = data;
						var html = "<table id='categoryImgManage_table_in'><tr><th>序号</th><th>imgId</th><th>name</th><th>图像</th><th>删除</th></tr>";
						for (var i = 0; i < categoryImgList.length; i++) {
							html += "<tr><td>" + (i + 1) + "</td><td>"
									+ categoryImgList[i].id + "</td><td>"
									+ categoryImgList[i].name
									+ "</td><td><img class='categoryIcon' src='" + getRealPath()
									+ "/pictures/categoryimg/" + categoryImgList[i].name
									+ "'></td><td onclick='delCategoryImg("+categoryImgList[i].id+")'>删除</td></tr>";
						}
						html += "</table>";
						$("#categoryImgManage_table").html(html);
					});
}

//删除分类图片
function delCategoryImg(id){
	$.post(
		'/show-message/delCategoryImg',
		{
			id:id
		},
		function(data){
			alert("删除成功："+data+"条");
			initCategoryImgManager();
		}
	);
}

// 当选择一级分类后，显示二级分类的列表
function showArticleManagerSecondCategoryList() {
	$(".admin-right-articlemanager-secondcategory").show();
	$("#articlemanager-secondcategorylist").show();

	var select = document.getElementById("articlemanager-firstcategorylist");
	var index = select.selectedIndex;
	var firstCategoryId = select.options[index].getAttribute("firstcategoryid");

	// 初始化二级下拉列表
	$.post('/show-message/findSecondCategoryListByFirstCategoryId', {
		firstCategoryId : firstCategoryId
	}, function(data) {
		var secondCategoryList = data;
		var html = "<option>未选择</option>";
		for (var i = 0; i < secondCategoryList.length; i++) {
			html += "<option secondcategoryid='" + secondCategoryList[i].id
					+ "'>" + secondCategoryList[i].name + "</option>";
		}
		$('#articlemanager-secondcategorylist').html(html);
		flagPage = 1;
	});
}

// 显示文章管理文章列表
function showArticleManagerArticleList(page) {
	if (page == undefined) {
		page = 1;
	}
	var select = document.getElementById("articlemanager-secondcategorylist");
	var index = select.selectedIndex;
	if (index != -1) {
		var secondCategoryId = parseInt(select.options[index]
				.getAttribute("secondcategoryid"));
		var secondCategoryIdList = new Array();
		secondCategoryIdList.push(secondCategoryId);
		$
				.ajax({
					type : "POST",
					url : '/show-message/findArticleListBySecondCategoryIdAndPage',
					traditional : true,
					data : {
						page : page,
						secondCategoryIdList : secondCategoryIdList
					},
					dataType : "json",
					async : true,
					success : function(data) {
						var articleList = data.list;
						var pageTotal = Math.ceil(data.totalCount / 10);
						var html = "<table><tr><th>序号</th><th>articleid</th><th>name</th><th>time</th><th>修改</th><th>删除</th></tr>";
						for (var i = 0; i < articleList.length; i++) {
							html += "<tr articleid='"
									+ articleList[i].id
									+ "' articlename='"
									+ articleList[i].name
									+ "'><td>"
									+ ((page - 1) * 10 + i + 1)
									+ "</td><td>"
									+ articleList[i].id
									+ "</td><td>"
									+ articleList[i].name
									+ "</td><td>"
									+ articleList[i].time
									+ "</td><td onclick='showUpdateArticle(this)'>修改</td><td onclick='delArticle(this)'>删除</td></tr>";
						}
						html += "</table>";
						$('#articlemanager-articlelist').html(html);
						initPageNav(page, pageTotal);
						$("#pageNav").show();
					}
				});
	}
}

// 删除文章
function delArticle(obj) {
	var tr = getRowObj(obj);
	var articleId = $(tr).attr("articleid");
	$.post('/show-message/delArticle', {
		id : articleId
	}, function(data) {
		if (data != 0) {
			alert("删除成功");
			showArticleManagerArticleList();
			pageFlag = 1;
		} else {
			alert("删除失败");
		}
	});
}

function showUpdateArticle(obj) {
	$("#updateArticle").show();
	$("#pageNav").hide();
	var tr = getRowObj(obj);
	var articleId = $(tr).attr("articleid");
	var articleName = $(tr).attr("articlename");
	$.post('/show-message/selectByPrimaryKey', {
		id : articleId
	}, function(data) {
		if (data != null) {
			$("#updateArticle-articleId").html(articleId);
			$("#updateArticle-articleName").val(articleName);
			UE.getEditor('updateArticle-articleContent').setContent(data.html);
			// 隐藏控件
			$("#articlemanager-articlelist").hide();
			$("#articleManager-addArticle").hide();
		}
	});
}

// 更新二级分类
function updateSecondCategory() {
	var id = $("#updateSecondCateoryId").html();
	var name = $("#updateSecondCategoryName").val();
	var firstcategoryid = $("#updateSecondCategoryBelongFC").attr(
			"firstcategoryid");
	var img = $("#updateSecondCateogryAllreadyChoiceImg").attr("imgId");
	if (id != "" & name != "" & firstcategoryid != "" & img != "") {
		$.post('/show-message/updateSecondCategory', {
			id : id,
			name : name,
			firstcategoryid : firstcategoryid,
			img : img
		}, function(data) {
			if (data != 0) {
				alert("更新成功");
				showSecondCategoryTable();
				$("#updateSecondCategoryWindow").jqxWindow("close");
			} else {
				alert("更新失败");
			}
		});
	} else {
		alert("有内容为空");
	}

}

// addArticle
function showAddArticle() {
	$("#articlemanager-articlelist").hide();
	$("#addArticle").show();
	$("#pageNav").hide();

}

// hideAddArticle
function hideAddArticle() {
	$("#articlemanager-articlelist").show();
	$("#addArticle").hide();
	$("#pageNav").show();
	// 清空编辑的内容
	$("#addArticle-articleName").val("");
	var editor = UE.getEditor('addArticle-articleContent');
	editor.execCommand('cleardoc');
}

// 初始化SecondCategoryManager
function initSecondCategoryManager() {
	$
			.post(
					'/show-message/findFirstCategoryList',
					function(data) {
						var firstCategoryList = data;
						var html = "<select id='SecondCategoryTable' onchange='showSecondCategoryTable(this)'><option>未选择</option>";
						for (var i = 0; i < firstCategoryList.length; i++) {
							html += "<option firstCategoryName='"
									+ firstCategoryList[i].name
									+ "' firstCategoryId='"
									+ firstCategoryList[i].id + "'>"
									+ firstCategoryList[i].name + "</option>";
						}
						html += "</select>";
						$("#secondCategoryManager-selectFirstCategory").html(
								html);
					});
}

// 展示二级分类的表
function showSecondCategoryTable(obj) {
	var id = $("#addSecondCategoryBelongFC").attr("firstCategoryId");
	if (obj != undefined) {
		var index = obj.selectedIndex;
		var id = obj.options[index].getAttribute("firstCategoryId");
		var name = obj.options[index].getAttribute("firstCategoryName");
		// 将一级分类的id和名称写入新增的窗口
		$("#addSecondCategoryBelongFC").html(name);
		$("#addSecondCategoryBelongFC").attr("firstCategoryId", id);
		// 将一级分类的id和名称写入修改的窗口
		$("#updateSecondCategoryBelongFC").html(name);
		$("#updateSecondCategoryBelongFC").attr("firstCategoryId", id);
	}
	// 显示表
	$
			.post(
					'/show-message/findSecondCategoryListByFirstCategoryId',
					{
						firstCategoryId : id
					},
					function(data) {
						var secondCategoryList = data;
						var html = "<table><tr><th>序号</th><th>id</th><th>name</th><th>img</th><th>修改</th><th>删除</th></tr>";
						for (var i = 0; i < secondCategoryList.length; i++) {
							html += "<tr secondCategoryImg='"
									+ secondCategoryList[i].img
									+ "' secondCategoryName='"
									+ secondCategoryList[i].name
									+ "' secondCategoryId='"
									+ secondCategoryList[i].id
									+ "'><td>"
									+ (i + 1)
									+ "</td><td>"
									+ secondCategoryList[i].id
									+ "</td><td>"
									+ secondCategoryList[i].name
									+ "</td><td>"
									+ secondCategoryList[i].img
									+ "</td><td onclick='showUpdateSecondCategoryWindow(this)'>修改</td><td onclick='deleteSecondCategory(this)'>删除</td></tr>";
						}
						html += "</table>";
						$("#secondCategoryManager-table").html(html);

					});
}

// 显示UpdateSecondCategoryWindow
function showUpdateSecondCategoryWindow(obj) {
	var tr = getRowObj(obj);
	$("#updateSecondCategoryWindow").jqxWindow("open");
	$("#updateSecondCategoryName").val($(tr).attr("secondCategoryName"));
	$('#updateSecondCateoryId').html($(tr).attr("secondCategoryId"));
	var secondCategoryImgId = $(tr).attr("secondCategoryImg");
	$.post('/show-message/selectCategoryImgById', {
		categoryImgId : secondCategoryImgId
	}, function(data) {
		var categoryImg = data;
		$("#updateSecondCateogryAllreadyChoiceImg")
				.attr("src", categoryImg.src);
		$("#updateSecondCateogryAllreadyChoiceImg").attr("ImgId",
				categoryImg.id);
	});
}

// 删除二级分类
function deleteSecondCategory(obj) {
	var tr = getRowObj(obj);
	var firstCategoryId = $(tr).attr("secondCategoryId");
	$.post('/show-message/delSecondCategory', {
		id : firstCategoryId
	}, function(data) {
		if (data != 0) {
			alert("删除成功");
			showSecondCategoryTable();
		} else {
			alert("删除失败");
		}
	});

}

// 向数据库更新FirstCategory
function okEidtFirstCategory() {
	var id = $("#editFirstCateoryId").html();
	var name = $("#editFirstCategoryName").val();
	var img = $("#editFirstCategoryAllreadyChoiceImg").attr("imgId");
	if (id != undefined & name != undefined & img != undefined) {
		$.post('/show-message/updateFirstCategory', {
			id : id,
			name : name,
			img : img
		}, function(data) {
			if (data != 0) {
				alert("更新成功");
				initFirstCategoryTable();
				$("#editFirstCategoryWindow").jqxWindow('close');
			}
		});
	}
}

// 向数据库传输newSecondCategory
function newSecondCategory() {
	var name = $("#addSecondCategoryName").val();
	var firstcategoryid = $("#addSecondCategoryBelongFC").attr(
			"firstCategoryId");
	var img = $("#addSecondCateogryAllreadyChoiceImg").attr("imgId");
	if (name != undefined & firstcategoryid != undefined & img != undefined) {
		$.post('/show-message/insertSecondCategory', {
			name : name,
			firstcategoryid : firstcategoryid,
			img : img
		}, function(data) {
			if (data != 0) {
				alert("添加成功");
				$("#addSecondCategoryWindow").jqxWindow('close');
				showSecondCategoryTable();
			} else {
				alert("添加失败");
			}
		});
	} else {
		alert("有内容未选择");
	}
}

// 向数据库传输newFirstCategory
function newFirstCategory() {
	var name = $("#addFirstCategoryName").val();
	var imgid = $('#allreadyChoiceImg').attr("imgId");
	if (imgid != undefined & name != undefined) {
		$.post('/show-message/insertFirstCategory', {
			name : name,
			img : imgid
		}, function(data) {
			$('#addFirstCategoryWindow').jqxWindow('close');
			initFirstCategoryTable();
		});
	} else {
		alert("没有选择图片或名称未填写！");
	}

}

// 显示新增一级分类ui
function showAddFirstCategory() {
	$('#addFirstCategoryWindow').jqxWindow('open');
}

// 显示选择分类图片的window
function showChoiceCategoryImg() {
	$('#choiceCategoryImgWindow').jqxWindow('open');
	$.post('/show-message/selectAllCategoryImg', function(data) {
		var categoryImgList = data;
		var html = "";
		for (var i = 0; i < categoryImgList.length; i++) {
			html += "<img class='categoryIcon' imgId='" + categoryImgList[i].id + "' src='pictures/categoryimg/"
					+ categoryImgList[i].name
					+ "' onclick='cateImgChoice(this)'/>";
		}
		$('#choiceCategoryTable').html(html);
	});
}

// 在分类图片里选择图片，并设置到新增一级分类的img里
function cateImgChoice(obj) {
	var imgId = $(obj).attr("imgId");
	var src = $(obj).attr("src");

	if ($('#choiceCategoryImgWindow').attr("display") != "none") {// 如果是新增一级分类
		$('#allreadyChoiceImg').attr('imgId', imgId);
		$('#allreadyChoiceImg').attr('src', src);
		$('#choiceCategoryImgWindow').jqxWindow('close');
	}
	if ($('#editFirstCategoryWindow').attr("display") != "none") {// 如果是修改一级分类
		$('#editFirstCategoryAllreadyChoiceImg').attr('imgId', imgId);
		$('#editFirstCategoryAllreadyChoiceImg').attr('src', src);
		$('#choiceCategoryImgWindow').jqxWindow('close');
	}
	if ($("#addSecondCategoryWindow").attr("display") != "none") {// 如果是新增二级分类
		$('#addSecondCateogryAllreadyChoiceImg').attr('imgId', imgId);
		$('#addSecondCateogryAllreadyChoiceImg').attr('src', src);
		$('#choiceCategoryImgWindow').jqxWindow('close');
	}
	if ($("#updateSecondCategoryWindow").attr("display") != "none") {// 如果是修改二级分类
		$('#updateSecondCateogryAllreadyChoiceImg').attr('imgId', imgId);
		$('#updateSecondCateogryAllreadyChoiceImg').attr('src', src);
		$('#choiceCategoryImgWindow').jqxWindow('close');
	}
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
									+ "' firstCategoryName='"
									+ firstCategory.name
									+ "' firstCategoryImgId='"
									+ firstCategory.img
									+ "'><td>"
									+ (i + 1)
									+ "</td><td>"
									+ firstCategory.id
									+ "</td><td>"
									+ firstCategory.name
									+ "</td><td>"
									+ firstCategory.img
									+ "</td><td onclick='showEditFirstCategoryWindow(this)'>修改</td><td onclick='deleteFirstCategory(this)'>删除</td></tr>";
						}
						html += "</table>";
						$("#admin-right #firstCategoryTable").html(html);
					});
}

// 取消修改一级分类
function cancleEditFirstCategory() {
	$('#editFirstCategoryWindow').jqxWindow('close');
}

// 显示修改一级分类的window
function showEditFirstCategoryWindow(obj) {
	$('#editFirstCategoryWindow').jqxWindow('open');
	var tr = getRowObj(obj);
	var firstCategoryId = $(tr).attr("firstCategoryId");
	var firstCategoryName = $(tr).attr("firstCategoryName");
	var firstCategoryImgId = $(tr).attr("firstCategoryImgId");// 分类图片id
	$('#editFirstCateoryId').html(firstCategoryId);
	$('#editFirstCategoryName').val(firstCategoryName);
	$.post('/show-message/selectCategoryImgById', {
		categoryImgId : firstCategoryImgId
	}, function(data) {
		var categoryImg = data;
		$('#editFirstCategoryAllreadyChoiceImg').attr("src", categoryImg.src);
		$('#editFirstCategoryAllreadyChoiceImg').attr("imgId", categoryImg.id);
	});

}

// 删除一级分类
function deleteFirstCategory(obj) {
	var tr = getRowObj(obj);
	var firstCategoryId = $(tr).attr("firstCategoryId");
	$.post('/show-message/delFirstCategory', {
		firstCategoryId : firstCategoryId
	}, function(data) {
		if (data != 0) {
			alert("删除成功");
			initFirstCategoryTable();
		} else {
			alert("删除失败，请重试！");
		}
	});
}

function checkSignIn() {
	var username = getCookie("username");
	if (username == undefined) {
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
	$("#admin-right #secondCategoryManager").hide();
	$("#admin-right-articlemanager").hide();
	$("#categoryImgManage").hide();
	$("#imgmanager").hide();
}

// 获取绝对路径
function getRealPath() {
	// 获取当前网址，如： http://localhost:8083/myproj/view/my.jsp
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录，如： myproj/view/my.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名，如：/myproj
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	// 得到了 http://localhost:8083/myproj
	var realPath = localhostPaht + projectName;
	return (realPath);
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
	while (obj.tagName.toLowerCase() != "tr") {
		obj = obj.parentNode;
		if (obj.tagName.toLowerCase() == "table")
			return null;
	}
	return obj;
}
