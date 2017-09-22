<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<%@ include file="../../../include/head.jsp"%>

<body>
	<div id="Grid"></div>
</body>
<script type="text/javascript">

var ligerG;
var ligerDG;

$(function(){
	ligerG=$("#Grid").ligerGrid({
		columns:[
				{display:"用户ID",name:"userId"},
				{display:"真实姓名",name:"realName"},
				{display:"登录密码",name:"password"},
				{display:"交易密码",name:"transactionPwd"},
				{display:"手机号码",name:"mobilePhone"},
				{display:"账户状态",name:"userStatus",render:function(msg){
					var str;
					if(msg.userStatus==10){
						str = "正常用户";
					}else if(msg.userStatus==20){
						str = "禁用";
					}
					return str;
					
				}},
				{display:"身份证号码",name:"idcardNo"},
		        ],
		        title:"会员管理",
		        url:"${ctx}/User/findUserhtml",
		        usePager:true,
		        page:1,
		        pageSize:3,
		        pageSizeOptions:[3,10,20],
		        selectRowButtonOnly:true,
		        checkbox:true,
		        toolbar:{items:[
		        	{text:'添加会员',icon:'add',click:add},
		        	{line:true},
		        	{text:'修改',icon:'add',click:update},
		        	{line:true},
		        ],
		        },	
	});
	ligerG.loadData();
});

function add(){
	
	ligerDG = $.ligerDialog.open({
		url:"${ctx}",
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
	    name:"addui",
		title:"添加",
	});
}

function update(){
	
	var row = ligerG.getSelectedRows();
	if(row.length!=1){
		$.ligerDialog.warn("请选择一行");
		return;
	}
	console.info(row);
	var shuju = row[0];
	console.info(shuju);
	 var userId= shuju.userId;
	 console.info(userId);
	ligerDG = $.ligerDialog.open({
		url:"${ctx}/User/Modifyhtml?userId="+userId,
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
        name:"updateUI",
        title: "修改用户"
	})
}










</script>

