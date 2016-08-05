$(document).ready(function(){
	insertArticleFirstCategoryDownList();
});

//初始化一级分类下拉列表
function insertArticleFirstCategoryDownList(){
	$.post(
		'/show-message/findFirstCategoryList.action',
		function(data){
			var html = "";
			html += "<option>未选择</option>";
			for (var i = 0; i < data.length; i++) {
				html += "<option firstcategoryid='"+data[i].id+"'>"+data[i].name+"</option>";
			}
			$("#insert-article-firstcategorylist").html(html);
		}
	);
}

//当一级分类改变时，改变二级分类
function insertArticleFirstCategoryChange(){
	 var obj=document.getElementById("insert-article-firstcategorylist");
	 var index=obj.selectedIndex;
	 var firstCategoryId=obj.options[index].getAttribute("firstcategoryid");
	 $.post(
		'/show-message/findSecondCategoryListByFirstCategoryId.action',
		{
			firstCategoryId:firstCategoryId
		},
		function(data){
			var html = "";
			html += "<option>未选择</option>";
			for (var i = 0; i < data.length; i++) {
				html += "<option secondcategoryid='"+data[i].id+"'>"+data[i].name+"</option>";
			}
			$("#insert-article-secondcategorylist").html(html);
			$(".insert-article-secondcategory").show();
		}
	 );
}

//当二级分类改变时，记录二级分类的id
function recordSecondCategoryId(){
	var obj=document.getElementById("insert-article-secondcategorylist");
	var index=obj.selectedIndex;
	var secondCategoryId=obj.options[index].getAttribute("secondcategoryid");
	$("#insert-article-secondcategoryid").val(parseInt(secondCategoryId));
}