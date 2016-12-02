<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>帖子详情页</title>
		<link rel="stylesheet" type="text/css" href="${base.contextPath}/static/css/detal.css"/>
	</head>
	<body>
		<div class="datal">
		<#list listPosts as listp>
			<h2 class="datal-tital"><span>${listp.title}</span></h2>
			<div class="datal-info">
				<span>楼主:${listp.author}</span>
				<span>时间:${listp.postsDate?string('yyyy-MM-dd HH:mm:ss')}</span>
				<span>回复:${count}</span>
			</div>
			<div class="datal-content">
				<p>${listp.postsContent}</p>
			</div>
		</#list>
			<div class="reply">
				<ul>
					<#list listReply as listReply>
					<li>
						<p><span>${listReply.committer}:</span><span>${listReply.replyDate?string('yyyy-MM-dd HH:mm:ss')}</span></p>
						<span class="reply1">${listReply.replyContent}</span>
						<span class="reply2">我要评论</span>
					</li>
					</#list>
				</ul>
			</div>
		</div>
		
	</body>
</html>
