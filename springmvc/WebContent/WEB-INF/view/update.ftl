<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改员工页面</title>
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
		//	$("#sel").find("option[value='${emp.deptId}']").attr("selected",true);
			$("#sel").val('${emp.deptId}');
		},"json");
		//表单文件上传
		$("#uploadFile").bind("change",function(){
		var data = new FormData($("#register")[0]);
			$.ajax({
				type:"post",
				url:"/springmvc/emp/updateImg",
				cache: false,
		        data: data,
				contentType: false,  
		        processData: false,
		        async: true,
		        success:function(data){
		        	$("#img").attr("src","${base.contextPath}/"+data);
		        	$("input[name='imgUrl']").val(data);
		        },
		        error:function(){
		        	alert("error!")
		        }
			});
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
    	<h1>修改员工信息</h1>
    </div>
    <div style="padding:20px 20px 40px;">
        <form  method="post"  enctype="multipart/form-data" action="${base.contextPath}/emp/update?id=${emp.id}" class="" id="register">
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 员工姓名：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="text" class="input-text-1"  datatype="*" value="${emp.name}" nullmsg="请输入用户名" name="name" id="name" placeholder="">
                </div>
                <div class="inline-block"></div>
            </div>
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block">邮箱：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="text" class="input-text-1" value="${emp.email}" datatype="e" name="email" id="email"   placeholder=" ">
                </div>
                <div class="inline-block"></div>
            </div>
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 手机号码：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="tel" class="input-text-1" value="${emp.telphone}" datatype="m" name="telphone" id="telphone"  placeholder="请输入手机号码">
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
                <div class="valGroup-item-1 inline-block"><span>*</span> 员工头像：</div>
                <div class="valGroup-item-2 formControls inline-block">
                	<img src="${base.contextPath}/${emp.imgUrl}" id="img"  style="width:40px;height:40px;"/>
                	<br>
                    <input type="file" id="uploadFile" name="uploadFile">
                    <input type="hidden"  name="imgUrl">
                </div>
                <div class="inline-block"></div>
            </div> 
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block">&nbsp;</div>
                <div class="valGroup-item-2 inline-block">
                    <input class="valGroup-btn" name="addButton" type="submit" value="&nbsp;&nbsp;确定添加&nbsp;&nbsp;">
                    <a style="cursor:pointer;display:none" id="btn_sub" target="_blank" class="valGroup-btn">确定修改</a>
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