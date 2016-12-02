<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加员工页面</title>
<link href="${base.contextPath}/static/css/regstyle.css" rel="stylesheet" type="text/css">
<link href="${base.contextPath}/static/css/valid.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base.contextPath}/static/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/index.js"></script>
<script type="text/javascript">
	$(function(){
		$.get("/springmvc/dept/find",function(data){
			$.each(data,function(i){
				$("#sel").append("<option value='"+data[i].id+"'>"+data[i].deptname+"</option>");
			});
		},"json");
		//添加雇员
	$("input[name='addButton']").bind("click",function(){
		var empName = $("input[name='name']").val();
		var empEmail = $("input[name='email']").val();
		var empTel = $("input[name='telphone']").val();
		var empDate = $("input[name='empDate']").val();
		var deptId = $("#sel option:selected").val();
		$("table").append("<tr><td></td><td>"+empName+"</td><td>"+empEmail+"</td><td>"+empTel+"</td><td>"+empDate+"</td><td>"+deptId+"</td></tr>")
	});
	});
</script>
</head>
<body style="background:#fff;">
<div class="hearder" style="padding:10px 0">
	<div class="warp">
        <a href="#"><img src=""></a>
    </div>
</div>
<div class="warp regCont" style="margin-top:-60px;margin-bottom: 100px;">
	<div class="tittle">
    	<h1>添加员工</h1>
    </div>
    <div style="padding:20px 20px 40px;">
        <form  method="post"  enctype="multipart/form-data" action="${base.contextPath}/emp/add" class="" id="register">
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 员工姓名：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="text" class="input-text-1" datatype="*" nullmsg="请输入用户名" name="name" id="name" placeholder="">
                </div>
                <div class="inline-block"></div>
            </div>
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block">邮箱：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="text" class="input-text-1" ajaxurl="/springmvc/email/check" datatype="e" name="email" id="email"   placeholder=" ">
                </div>
                <div class="inline-block"></div>
            </div>
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 手机号码：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="tel" class="input-text-1" datatype="m" name="telphone" id="telphone"  placeholder="请输入手机号码">
                </div>
                <div class="inline-block"></div>
            </div> 
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 部门名称：</div>
                <div class="valGroup-item-2 formControls inline-block">
                	<select name="deptId" id="sel" style="height: 36px;">
                		<option value="0">--请选择部门--</option>
                	</select>
                </div>
                <div class="inline-block"></div>
            </div> 
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 上传头像：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="file" nullmsg="请选择头像" name="uploadFile">
                </div>
                <div class="inline-block"></div>
            </div> 
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block">&nbsp;</div>
                <div class="valGroup-item-2 inline-block">
                    <input class="valGroup-btn" name="addButton" type="submit" value="&nbsp;&nbsp;确定添加&nbsp;&nbsp;">
                    <a style="cursor:pointer;display:none" id="btn_sub" target="_blank" class="valGroup-btn">确定添加</a>
                </div>
            </div>
        </form>
    </div>
    
</div>
<script>

$(document).ready(function(){
	var demo = $("#register").Validform({
		tiptype:2
	});
	demo.unignore("#sel");
})
;
</script>
</body>
</html>