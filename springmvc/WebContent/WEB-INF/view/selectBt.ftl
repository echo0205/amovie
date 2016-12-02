<!DOCTYPE html>
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
</head>
<body>
	<div style="margin: 0 auto;width: 1200px;margin-top: 20px;">
		<div class="btn-group" id="toolbar">
				<button id="btn_add" class="btn btn-default" type="button">
					<span class="glyphicon glyphicon-plus"></span>添加
				</button>
				<button id="btn_edit" class="btn btn-default" type="button">
					<span class="glyphicon glyphicon-pencil"></span>修改
				</button>
				<button id="btn_del" class="btn btn-default" type="button">
					<span class="glyphicon glyphicon-remove"></span>删除
				</button>
			</div>
		<table id="table" data-toggle="table">
		</table>
	</div>
</body>

</html>