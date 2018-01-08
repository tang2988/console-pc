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
			{display:"订单ID",name:"orderId", width: 100},
			{display:"产品ID",name:"productId", width: 100},
			{display:"数量",name:"quantity", width: 100},
			{display:"订单金额",name:"orderAmount", width: 100},
			{display:"状态",name:"orderStatus", width: 100,render:function(item){
				
				var str;
					if(item.orderStatus ==10){
						str = "下单成功";
					}else if(item.orderStatus==20){
						str = "支付成功";
					}else if(item.orderStatus==30){
						str = "已发货";
					}
					else if(item.orderStatus==40){
						str = "已收货";
					}
					else if(item.orderStatus==50){
						str = "已退货";
					}
					else if(item.orderStatus==60){
						str = "退货申请";
					}
					else if(item.orderStatus==90){
						str = "失败";
					}
				return str;
				}
			},
			
			{display:"下单时间",name:"orderTime",width:150,render:function(item){
				var date = new Date(item.orderTime);
				return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"-"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
				}
			},
		
				
			{display:"支付时间",name:"timeofpayment",width:150,render:function(item){
				if(item.timeofpayment==''  || item.timeofpayment==null || item.timeofpayment==undefined){
					return '';
				}else{
					var date = new Date(item.timeofpayment);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
				
				}
			},
			{display:"发货时间",name:"deliverytime",width:150,render:function(item){
				if(item.deliverytime==""|| item.deliverytime==null || item.deliverytime==undefined){
					
					return '';
			}else{
				var date = new Date(item.deliverytime);
				return date.toString("yyyy-MM-dd HH:mm:ss");
				}
			}
			
			},
			{display:"收货时间",name:"receivingtime",width:150,render:function(item){
				if(item.receivingtime==""|| item.receivingtime==null || item.receivingtime==undefined){
					
						return '';
				}else{
					var date = new Date(item.receivingtime);
					return date.toString("yyyy-MM-dd HH:mm:ss");
					}
				}
			},
			{display:"失败时间",name:"failuretime", width:160,render:function(item){
				
				if(item.failuretime==null){
					return "";
				}else{
					var date = new Date(item.failuretime);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
			
				
			}},
			{display:"失败原因",name:"causeoffailure", width: 100},
			{display:"地址ID",name:"addressId", width: 100},
			{display:"发票信息",name:"invoiceInformation", width: 100},
			{display:"用户ID",name:"userId", width: 100},
			{display:"配送公司",name:"distributioncompany", width: 100},
			{display:"快递单号",name:"trackingNumberCourierNumber", width: 100},
			{display:"备注",name:"remark", width: 100},
			{display:"付款方式",name:"paymentMethod", width: 100},
		   ],
		   checkbox:true,
		   title:"订单",
		   pageSizeOptions:[3,5,10],
		   pageSize:3,
		   usePager:true,
		   url:"${ctx}/order/findAll.do",
		   selectRowButtonOnly:true,
		   toolbar:{items:[
			          {text:"发货",icon:"add", click:update},
			          {text:"退货",icon:"add", click:Returngoods},
			          {text:"下载",icon:"add", click:Dows},
			          ],
		  
		   }
		  
	});
	ligerManager.loadData();
});

function Returngoods(){
	
	 var row = ligerManager.getSelectedRows();
	 if(row.length!=1){
		 $.ligerDialog.warn("请选择一行");
		 return;
	 }
	 console.info(row);
	  var abc= row[0]; 
	  console.info(abc);
	  var  orderId = abc.orderId;
	  console.info(orderId);
	  openWindow = $.ligerDialog.open({
		url:"${ctx}/order/Returngoods.do?orderId="+orderId,
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
        name:"updateUI",
        title: "发货"
	})
}
function update(){
	
	 var row = ligerManager.getSelectedRows();
	 if(row.length!=1){
		 $.ligerDialog.warn("请选择一行");
		 return;
	 }
	 console.info(row);
	  var abc= row[0]; 
	  console.info(abc);
	  var  orderId = abc.orderId;
	  console.info(orderId);
	  openWindow = $.ligerDialog.open({
		url:"${ctx}/order/delivery.html?orderId="+orderId,
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
       name:"updateUI",
       title: "发货"
	})
}
function Dows(){
	
	window.location = '${ctx}/order/Xls.do';
}
	
</script>


