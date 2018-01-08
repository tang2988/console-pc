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
		    {display:"账户ID",name:"accountId",width:100},
			{display:"账户余额",name:"Accountbalance",width:100},
			{display:"账户状态",name:"AccountStatus",width:100,render:function(status){
				var str = "";
				if(status.AccountStatus==10){
					str = "正常";
				}else if(status.AccountStatus==20){
					str = "禁用";
				}
				return str;
				
			}},
			{display:"银行ID",name:"banklistId",width:100},
		
			{display:"银行列表ID",name:"rechargeId",width:100},
			{display:"充值金额",name:"recharmoney",width:100},
			{display:"用户ID",name:"UserId",width:100},
			{display:"充值时间",name:"rechargeTime",width:'150',render:function(time){
				if(time.rechargeTime==null || time.rechargeTime=='' ||time.rechargeTime==undefined){
					return "";
				}else{
					var date = new Date(time.rechargeTime);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
				
				
			}
			},
			{display:"成功时间",name:"succeedTime",width:'150',render:function(time){
				
				if(time.succeedTime==null || time.succeedTime==""){
					return "";
				}else{
					var date = new Date(time.succeedTime);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
			}},
			{display:"状态",name:"rechargeStatus",width:'150',render:function(status){
				var str = "";
				if(status.rechargeStatus==10){
					str = "申请";
				}else if(status.rechargeStatus==20){
					str = "充值成功";
				}else if(status.rechargeStatus==90){
					str = "充值失败";
				}
				return str;
				
			}},
			{display:"失败时间",name:"errorTime",width:'150',render:function(time){
				
				if(time.errorTime==null || time.errorTime==""){
					return "";
				}else{
					var date = new Date(time.errorTime);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
			}},
		   ],
		   checkbox:true,
		   title:"充值订单",
		   pageSizeOptions:[7,10,20],
		   pageSize:7,
		   page:1,
		   usePager:true,
		   url:"${ctx}/topuprecharge/Topuprecharge.do",
		   selectRowButtonOnly:true,
		   dateFormat: "yyyy-MM-dd",
		   
		  
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
	  var  productId = abc.productId;
	  console.info(productId);
	  openWindow = $.ligerDialog.open({
		url:"${ctx}/produ/updateProdu?productId="+productId,
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
        name:"updateUI",
        title: "修改"
	});
}
function add(){
	
	  openWindow = $.ligerDialog.open({
		url:"${ctx}/produ/addhtml",
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
       name:"addui",
       title: "添加"
	})
}
	
</script>


