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
			{display:"新闻ID",name:"mediaId"},
			{display:"图片",name:"picture",width:400,height:500,render:function(row){
				return "<img src='"+row.picture+"' height:2000px/>"
			}},
			{display:"内容",name:"content"},
			{display:"标题",name:"title"},
			{display:"时间",name:"time",render:function(it){
				var date = new Date(it.time);
				return date.toString("yyyy-MM-dd HH:mm:ss");
			}},
		   ],
		   width:"100%",
		   
		   checkbox:true,
		   title:"新闻",
		   pageSizeOptions:[3,10,15],
		   pageSize:3,
		   usePager:true,
		   url:"${ctx}/mediaa/findAll.do",
		   selectRowButtonOnly:true,
		   dateFormat: "yyyy-MM-dd",
		   toolbar:{items:[
			          {text:"修改新闻",icon:"add", click:update},
			          {text:"添加新闻",icon:"add", click:add},
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
	  var  mediaId = abc.mediaId;
	  console.info(mediaId);
	  openWindow = $.ligerDialog.open({
		url:"${ctx}/mediaa/modifymedia?mediaId="+mediaId,
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
        name:"updateUI",
        title: "修改新闻"
	})
}

function add(){
	  openWindow = $.ligerDialog.open({
		url:"${ctx}/mediaa/add.html",
		width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
       name:"updateUI",
       title: "添加新闻"
	})
}
	
</script>


