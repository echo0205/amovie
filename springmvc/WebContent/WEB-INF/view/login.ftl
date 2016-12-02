
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="${base.contextPath}/static/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${base.contextPath}/static/css/bootstrap-table.css"/>
<script type="text/javascript" src="${base.contextPath}/static/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/bootstrap-table.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/index.js"></script>
<link href="${base.contextPath}/static/css/regstyle.css" rel="stylesheet" type="text/css">
<link href="${base.contextPath}/static/css/valid.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base.contextPath}/static/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${base.contextPath}/static/js/index.js"></script>
</head>
<body style="background:#fff;">
<div class="hearder" style="padding:10px 0">
	<div class="warp">
        <a href="#"><img src=""></a>
    </div>
</div>
<div class="warp regCont" style="margin-top:-60px;margin-bottom: 100px;">
	<div class="tittle">
    	<h1>请登录</h1>
    </div>
    <div style="padding:20px 20px 40px;">
        <form  method="post" action="${base.contextPath}/UserLogin/login" class="" id="regist">
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 用户名：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="text" class="input-text-1" datatype="*" nullmsg="请输入用户名" name="name" id="name" placeholder="">
                </div>
                <div class="inline-block"></div>
            </div>
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block">密码：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="password" class="input-text-1" datatype="*6-16" name="password" id="password"   placeholder=" ">
                </div>
                <div class="inline-block"></div>
            </div>
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block">&nbsp;</div>
                <div class="valGroup-item-2 inline-block">
                    <input class="valGroup-btn" name="addButton" type="submit" value="&nbsp;&nbsp;确定登录&nbsp;&nbsp;">
                    <a style="cursor:pointer;display:none" id="btn_sub" target="_blank" class="valGroup-btn">确定登录</a>
                </div>
            </div>
        </form>
    </div>
    
</div>
<script>

$(document).ready(function(){
	var demo = $("#regist").Validform({
		tiptype:2
	});
	demo.unignore("#sel");
})
;
</script>
</body>
</html>