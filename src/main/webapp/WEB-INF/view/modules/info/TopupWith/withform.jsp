<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<%@ include file="../../../include/head.jsp"%>

<body>
	<div id=Gird></div>
</body>
<script type="text/javascript">
<!--Grid加载页面-->

var ligerManager;

var openWindow;
$(function(){
	ligerManager = $("#Gird").ligerGrid({
		columns:[
			{display:"账户ID",name:"accountId"},
			{display:"冻结资金",name:"FrozenCapital"},
			{display:"账户余额",name:"Accountbalance"},
			{display:"账户状态",name:"AccountStatus",render:function(status){
				var str;
				if(status.AccountStatus==10){
					str = "正常用户";
					
				}else if (status.rechargeStatus==20){
					str = "禁用";
				}
				return str;
				
			}},
			{display:"银行卡id",name:"withdrawalId"},
			{display:"申请状态",name:"rechargeStatus",render:function(status){
				var str;
				if(status.rechargeStatus==10){
					str = "申请成功";
					
				}else if (status.rechargeStatus==20){
					str = "提现成功";
				}else if (status.rechargeStatus==90){
					str = "提现失败";
				}
				return str;
			}
				
				},
			{display:"提现金额",name:"withdrawdMoneny"},
			{display:"用户ID",name:"UserId"},
			{display:"申请时间",name:"applyfortime",width:'150',render:function(time){
				if(time.applyfortime==null || time.applyfortime==""){
					return "";	
				}else{
					var date = new Date(time.applyfortime);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
				
			}
			},
			{display:"成功时间",name:"succeedtime",width:'150',render:function(time){
				if(time.succeedtime==null || time.succeedtime==""){
					return "";	
				}else{
					var date = new Date(time.succeedtime);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
				
			}},
			{display:"失败时间",name:"errortime",width:'150',render:function(time){
				if(time.errortime==null || time.errortime==""){
					return "";	
				}else{
					var date = new Date(time.errortime);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
				
			}},

		   ],
		   checkbox:true,
		   title:"提现订单",
		   pageSizeOptions:[5,10,20],
		   pageSize:5,
		   page:1,
		   usePager:true,
		   url:"${ctx}/Withdrawalform/with.do",
		   selectRowButtonOnly:true,
		   dateFormat: "yyyy-MM-dd",
		   toolbar:{items:[
		                   {text:"通过",icon:'add',click:update},
		                   
		                   ],
		   
			   
			   
		   },
	});
	ligerManager.loadData();
});

function update(){
	 var row = ligerManager.getSelectedRows();
	 if(row.length!=1){
		 $.ligerDialog.warn("请选择一行");
		 return;
	 }
	 console.info(row);
	  var abc= row[0]; 
	  console.info(abc);
	 var withdrawalId  = abc.withdrawalId;
	 console.info(withdrawalId);
	openWindow = $.ligerDialog.open({
		url:"${ctx}/Topupwith/findById?withdrawalId="+withdrawalId,
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
        name:"updateUI",
        title: "修改"
		
	})
	
	
}

	
</script>


