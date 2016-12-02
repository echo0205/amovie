<!DOCTYPE html>
<#import "/inc/page.ftl" as paging>
<html>
<head>
<meta charset="UTF-8">
<title>员工管理页面</title>
<link rel="stylesheet" type="text/css" href="${base.contextPath}/static/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${base.contextPath}/static/css/bootstrap-table.css"/>
<script type="text/javascript" src="${base.contextPath}/static/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/bootstrap-table.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/index.js"></script>
<link rel="stylesheet" type="text/css" href="${base.contextPath}/static/css/select.css"/>
</head>
<script type="text/javascript">
 $().ready(function(){
 	//跳转到添加页面
	$("button[name='toAdd']").bind("click",function(){
		window.location.href="toAdd";
	});
	
	$("input[name='updateButton']").bind("click",function(){
		var empName = $("input[name='name']").val();
		var empEmail = $("input[name='email']").val();
		var empTel = $("input[name='telphone']").val();
		var deptId = $("input[name='deptId']").val();
		$("table td:eq(2)").html(empName);
		$("table td:eq(3)").html(empEmail);
		$("table td:eq(4)").html(empTel);
		$("table td:eq(6)").html($("#sel option").val());
	});
 });
</script>
<body>
<button type="button" name="toAdd">添加员工信息</button>
	<div style="magin-left:100px;">
	欢迎您，<a href="#">${userName}</a>&nbsp;&nbsp;&nbsp;
	<a href="#">点击</a>退出登录
	</div>
	<table border="1" style="margin: 0 auto">
		<tr>
			<th>序号号</th>
			<th>员工编号</th>
			<th>姓名</th>
			<th>头像</th>
			<th>邮箱</th>
			<th>电话</th>
			<th>入职时间</th>
			<th>部门编号</th>
			<th>部门名称</th>
			<th colspan="2">操作</th>
		</tr>
		<#list list as empVo>
		<tr>
		<td>${empVo_index+1}</td>
		<td>${empVo.emp.id}</td>
		<td>${empVo.emp.name}</td>
		<td><img src="${base.contextPath}/${empVo.emp.imgUrl}"  style="width:40px;height:40px;"/></td>
		<td>${empVo.emp.email}</td>
		<td>${empVo.emp.telphone}</td>
		<td>${empVo.emp.regDate?string('yyyy-MM-dd HH:mm:ss')}</td>
		<td>${empVo.emp.deptId}</td>
		<td>${empVo['deptName']}</td>
		<td><a href="${base.contextPath}/emp/delete?id=${empVo.emp.id}">删除</a></td>
		<td><a href="${base.contextPath}/emp/toUpdate?id=${empVo.emp.id}">修改</a></td>
		</tr>
		</#list>
	</table>
	<@paging.page url="${base.contextPath}/emp/select1"   pageTotal="${pageTotal}"  pageSize="5" pageNow="${cpg}" rows="${count}" />
</body>
</html>