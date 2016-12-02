<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>论坛帖子及回复</title>
		<link rel="stylesheet" type="text/css" href="${base.contextPath}/static/css/postsIndex.css"/>
	</head>
	<body>
		<div class="forum">
			<span class="forum-head">热帖榜</span>
			<div class="forum-body">
				<ul>
					<#list listPosts as list>
					<li>
						<a href="${base.contextPath}/posts/detail?id=${list.id}">${list.title}</a>
						<span>作者:${list.author}</span>
					</li>
					</#list>
				</ul>
			</div>
		</div>
	</body>
</html>
