<style type="text/css">
	*{margin: 0;padding: 0;}
	a{display: inline-block;text-decoration: none;float: left;}
	span{float: left;margin: 0 10px;}
	.paging{position: relative;margin: 10px 10px;}
</style>
<#macro page url  pageTotal  pageSize pageNow rows>
	</style>
	<div class="paging">
			<a href="${url}?cpg=1">首页</a>
			<#if pageNow==1>
				<span style="color:#666;"><<上一页</span>
			<#else>
				<a href="${url}?cpg=${pageNow?number-1}"><<上一页</a>
			</#if>
				当前第${pageNow}页
			<#if pageNow==pageTotal>
				<span style="color:#666;">下一页>></span>
			<#else>
			<a href="${url}?cpg=${pageNow?number+1}">下一页>></a>
			</#if>
			<a href="${url}?cpg=${pageTotal?number}">最后一页</a>
			<span>共${pageTotal}页 </span>
			<span>共${rows}条数据 </span>
	</div>
</#macro>