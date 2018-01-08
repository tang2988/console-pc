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
		    {display:"订单ID",name:"orderId",width:100},
			{display:"产品ID",name:"productId",width:100},
			{display:"用户Id",name:"userId",width:100},
			{display:"下单时间",name:"orderTime",width:150,render:function(item){
				if(item.orderTime==null || item.orderTime=='' || item.orderTime==undefined){
					return '';
				}else{
					var date = new Date(item.orderTime);
					return date.toString("yyyy-MM-dd HH:mm:ss")
				}
			}
			},
			{display:"支付时间",name:"paymentTime",width:150,render:function(payment){
				
				if(payment.paymentTime==null || payment.paymentTime=="" ||payment.paymentTime==undefined){
					return "";
				}else{
					var date = new Date(payment.paymentTime)
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
			}},
			
			{display:"起息日",name:"interestTime",width:100,render:function(interes){
				if(interes.interestTime==null || interes.interestTime=="" ||interes.interestTime==undefined){
					return "";
				}else{
					var date = new Date(interes.interestTime);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
				
			}},
			{display:"止息日",name:"ceaseDay",width:100,render:function(cease){
				if(cease.ceaseDay==null || cease.ceaseDay=="" || cease.ceaseDay==undefined){
					return "";
				}else{
					var date = new Date(cease.ceaseDay);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
				
			}},
			{display:"回款日",name:"cashBackDay",width:100,render:function(cashBack){
				if(cashBack.cashBackDay==null || cashBack.cashBackDay=="" || cashBack.cashBackDay==undefined){
					return "";
				}else{
					var date = new Date(cashBack.cashBackDay);
					return date.toString("yyyy-MM-dd HH:mm:ss");
				}
				
			}},
			
			{display:"支付方式",name:"paymentMethod",width:150,render:function(status){
				var string;
				if(status.paymentMethod==10){
					string = "余额支付";
				}else if(status.paymentMethod==20){
					string = "网银支付";
				}
				return string;
			}},
			{display:"订单金价",name:"orderPrice",width:150,render:function(price){
				
			
				var _n = parseFloat(price.orderPrice);
				n = _n.toFixed(2);
					　　var re=/\d{1,3}(?=(\d{3})+$)/g;
					　　var n1=n.replace(/^(\d+)((\.\d+)?)$/,function(s,s1,s2){return s1.replace(re,"$&,")+s2;});
					　　return n1;
					}
			},
			{display:"订单总额",name:"totalOrder",width:150,render:function(ordertotal){
				
				 var _n = parseFloat(ordertotal.totalOrder);
				n = _n.toFixed(2);
					　　var re=/\d{1,3}(?=(\d{3})+$)/g;
					　　var n1=n.replace(/^(\d+)((\.\d+)?)$/,function(s,s1,s2){return s1.replace(re,"$&,")+s2;});
					　　return n1;
					} 
					
			},
			{display:"买入克重",name:"buyWeight",width:150},
			{display:"利率",name:"interestRate",width:150,render:function(InterestRate){
				var number = new Number(InterestRate.interestRate);
				
				
				var str = number.toFixed(2);
				return str.concat("%");
			}},
			{display:"备注",name:"remark",width:150},
			{display:"版本号",name:"versionNo",width:150},
			{display:"插入时间",name:"createTime",width:150},
		   ],
		   checkbox:true,
		   title:"稳盈金订单",
		   pageSizeOptions:[7,10,20],
		   pageSize:7,
		   page:1,
		   usePager:true,
		   url:"${ctx}/steady/findByPage",
		   selectRowButtonOnly:true,  
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
		url:"",
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
       name:"addui",
       title: "添加"
	})
}
function commafyback(num) 
{ 
var x = num.split(','); 
return parseFloat(x.join("")); 
} 
function comdify(n){
var _n = parseFloat(n);
n = _n.toFixed(2);
	　　var re=/\d{1,3}(?=(\d{3})+$)/g;
	　　var n1=n.replace(/^(\d+)((\.\d+)?)$/,function(s,s1,s2){return s1.replace(re,"$&,")+s2;});
	　　return n1;
	}; comdify("1111111.100")

</script>


