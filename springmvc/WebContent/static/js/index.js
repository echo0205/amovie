$().ready(function(){
	
	initTable();
	$("search").bind("click",initTable);
	del=function(index){
		$('#table').bootstrapTable("checked",index);
	}
});


function initTable(){
	//bootstrap table
	$("#table").bootstrapTable('destroy');//先销毁表格
	$("#table").bootstrapTable({
		url:'/springmvc/emp/select',
		dataType:'json',
		method:"get",
		striped:true,//表格显示条纹
		pagination:true,//分页
		pageSize:3,//每页显示的记录数
		pageNumber:1,//当前第几页
		pageList:[5,10,15,20,35],//记录数可选列表
		search:true,//是否启用查询
		toolbar:'#toolbar',
		showColumns:true,//显示下拉框勾选要显示的列
		showRefresh:true,//显示刷新按钮
		sidePagination:'server',//服务端处理分页
		columns:[
			{
				field:'checkbox',
				checkbox:true,
				align:'center'
			},
			{
				field:'emp.id',
				title:'员工编号',
				align:'center'
			},
			{
				field:'emp.name',
				title:'员工姓名',
				align:'center'
			},
			{
				field:'emp.imgUrl',
				title:'头像',
				align:'center',
				formatter:function(value){
					var e = '<img src="/springmvc/'+value+'" width="40px" height="40px"/>';
					return e;
				}
			},
			{
				field:'emp.email',
				title:'邮箱',
				align:'center'
			},
			{
				field:'emp.telphone',
				title:'电话',
				align:'center'
			},
			{
				field:'emp.regDate',
				title:'入职时间',
				align:'center'
			},
			{
				field:'emp.deptId',
				title:'部门编号',
				align:'center'
			},
			{
				field:'deptName',
				title:'部门名称',
				align:'center'
			},
			{
				title:'操作',
				field:'id',
				align:'center',
				formatter:function(value,row,index){
					//springmvc/emp/delete?id='+row.emp.id+'
					var e = '<a href="" onclick="del('+index+')">删除</a>&nbsp';
					var d = '<a href="/springmvc/emp/toUpdate?id='+row.emp.id+'" >编辑</a>';
					return e+d;
				}
			}
		]
	});
}