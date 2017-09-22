<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ include file="../../../include/head.jsp"%>
  <body>
  	<div id="xxh"></div>
  </body>
 <script type="text/javascript">
 

 
 
 	$("#xxh").ligerGrid({
 		columns:[
 		        
 			{display:"谢雄辉",id:"xxh",name:"xxh"},
 			{display:'性别',id:'sex',name:'sex'},
 			{display:'地址',id:'address',name:'address'},
 			{display:'手机号码',id:'phone',name:'phone'},
 			],
 			url:'',
 			height:'120%',
 			title:'个人信息',
 			page:2,
 			pageSizeOptions:[10,20,30],
 			checkbox:true,
 			toolbar:{items:[
 			                
 			        			{text:'添加',icon:"add", click: update},
 			        			
 			                
 			                ]
 					},
 			
 	})
 	
 function update(){
 		
 		
 		
 		$.ligerDialog.open({
 			url:'${ctx}/notice/update',
 			
 			
 			width:600,
 			height:500,
 			showToggle:true,
 			showMin:true,
 			showMax:true,
 			isResize:true,
 			modal:true,
 			name:'xxh',
 			title:'添加',
 			
 			
 			
 		})
 		
 		
 		
 	}
 	
</script>

