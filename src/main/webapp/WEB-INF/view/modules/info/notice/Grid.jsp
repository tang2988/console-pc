<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ include file="../../../include/head.jsp"%>


  <body>
    <div id=maingrid4></div>
    <div id="xxh"></div>
   	<div id="xxhxxh"></div>
    
    123<input type="button" name="success" value="success"/>
  </body>
  <script type="text/javascript">
  $("#maingrid4").ligerGrid({
	                  columns: [
	                   								{ display: "标题", name: "title",isSort:true},
    	                                            { display: "副标题", name: "title2",align:'center'},
    	                                            { display: "公告时间", name: "noticeTime",hide:'123'},
    	                                            { display: "正文", name: "content"}
	                   ],
	                  

	              	
	                   title:'谢雄会',
	                   usePager:true,
	                   page:3,
	                   pageSize:5,
	                   pageSizeOptions:[5,20,30],
	                   minColToggle:2,
	                   checkbox:true,
	                   minColToggle:3,
	                   showTableToggleBtn:true,
	                   allowAdjustColWidth:10,
	                   checkbox:false,
	                   url:"${ctx}/notice/findList.do",
	                   checked:true,
	                   allowHideColumn:false,
	                   enabledEdit:true,
	                   dateFormat:'yyyy-MM-dd',
	                   fixedCellHeight:false,
	                   mouseoverRowCssClass:'background-color:red',
	                  
	                   
	              });
 
  /*  var g = $("#maingrid4").ligerGrid();
 	g.setColumnWidth('title', '120px');
 	
	var b = $("#maingrid4").ligerGrid();
        b.setHeight('15px');
    
    $.ligerDialog.waitting("正在保存");
    setTimeout(function(){
    	$.ligerDialog.success("保存吃呢额");
    	$.ligerDialog.closeWaitting();
    	
    	
    },2000) */
    $(function(){
    	$.ligerDialog.open({
    		width:'600',
    		height:'400',
    		content:'谢雄辉您好你您',
    		target:$("#xxh"),
    		left:200,
    		top:2,
    		isResize:true,
    		closeWhenEnter:true,
    		isHidden:false,
    		title:'联系',
    		showMin:true,
    		slide:true,
    		layoutMode:2,
    		buttons:[
    		         {text:'确定',onclick:function(i,d){
    		        	
    		         }
    		        	 
    		         },
    		         {text:'取消'},
    		
    		
    		]
    	});
    	
    });
  
   
  </script>

