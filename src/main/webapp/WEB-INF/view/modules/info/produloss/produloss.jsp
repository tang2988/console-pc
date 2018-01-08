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
		    {display:"产品ID",name:"productId",width:100},
			{display:"产品名称",name:"productName",width:100},
			{display:"预期年化金息",name:"expectedAnnualizedInterestRate",width:100,render:function(addInterest){
				var number = new Number(addInterest.expectedAnnualizedInterestRate);
				return number.toFixed(2).concat("%");
			}},
			{display:"活动加息",name:"activityPlusInterest",width:100,render:function(addInterest){
				var number = new Number(addInterest.activityPlusInterest);
				return number.toFixed(2).concat("%");
			}},
			{display:"起购金额",name:"sumofMoneyPurchaseddecimal",width:100,render:function(sumMonery){
				var number = new Number(sumMonery.sumofMoneyPurchaseddecimal);
				return number.toFixed(2);
			
			}},
			{display:"状态",name:"productStatus",width:100,render:function(status){
				
				//10上架20下架,
				var str = "";
				if(status.productStatus==10){
					str="上架";
				}else if(status.productStatus==20){
					str="下架";
				}
				return str;
			}},
		   ],
		   checkbox:true,
		   title:"产品列表",
		   toolbar:{items:[
					          {text:"添加产品",icon:"add", click:add},
					          
					          ],
				  
				   },
	
		   pageSizeOptions:[3,10,20],
		   pageSize:3,
		   page:1,
		   usePager:true,
		   url:"${ctx}/productloss/findloss",
		   selectRowButtonOnly:true,  
	});
	ligerManager.loadData();
});


function add(){
	
	  openWindow = $.ligerDialog.open({
		url:"${ctx}/productloss/addProductProditUl",
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
       name:"addui",
       title: "添加"
	})
}


</script>


