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
			{display:"产品ID",name:"productId"},
			{display:"产品类型",name:"productType"},
			{display:"品牌",name:"brand"},
			{display:"克重",name:"gramWeight"},
			{display:"产品价格",name:"productPrice"},
			{display:"库存",name:"bepertory"},
			{display:"详情页",name:"detailpage"},
			{display:"产品名称",name:"productName"},	
			{display:"状态",name:"productStatus",render:function(item){
				
				var str = "";
					if(item.productStatus ==10){
						str = "上架";
					}else if(item.productStatus==20){
						str = "下架";
					}
				return str;
				}
			},
			
		   ],
		   checkbox:true,
		   title:"产品",
		   pageSizeOptions:[3,10,20],
		   pageSize:3,
		   page:1,
		   usePager:true,
		   url:"${ctx}/produ/findAll",
		   selectRowButtonOnly:true,
		   dateFormat: "yyyy-MM-dd",
		   toolbar:{items:[
			          {text:"修改产品",icon:"add", click:update},
			          {text:"添加产品",icon:"add", click:add},
			          {text:"downloadExcel",icon:"add", click:downloadExcel},
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

function downloadExcel(){
	window.location = '${ctx}/produ/findAllPageIntoXLS';
}
	
</script>


