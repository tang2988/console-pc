<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<%@ include file="../../../include/head.jsp"%>


<body style="padding:5px">

	<div id="searchbar" style="margin-bottom: 10px;"></div>

	<div id="t1"></div>

</body>
<script type="text/javascript">

// 搜索使用
var parms;

var openWindow;

var ligerManager;

            
// 添加用户            
function add() {
  openWindow=$.ligerDialog.open({
            url: '${ctx}/notice/addUI', 
            width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true, 
            name:"addUI",
            title: "添加"
/*             , buttons: [
            { text: '保存', onclick: function(item, dialog) { window.frames["addUI"].saveformSubmit();} },
            { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
        ] */
    });
}

// 修改用户
function update() {
	
	var rows =ligerManager.getSelectedRows();
	
	if(rows.length!=1){
		$.ligerDialog.warn("请选择一行");
		return;
	}
	
	 var shuju = rows[0];
	 console.info(shuju);
	var noticeId = shuju.noticeId;
	console.info(noticeId);
	
	 var ca = ligerManager.getAdded();
	 console.info(ca);
	
	
	
       openWindow=$.ligerDialog.open({
            url: '${ctx}/notice/update?noticeId='+noticeId,
            width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
            name:"updateUI",
            title: "修改用户"
/*             , buttons: [
                <shiro:hasPermission name="user_update">                  
            { text: '保存', onclick: function(item, dialog) { window.frames["updateUI"].saveformSubmit();} },
                </shiro:hasPermission>
            { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
             ] */
        });
}


//修改用户
function update2(noticeId) {
       openWindow=$.ligerDialog.open({
            url: '${ctx}/notice/update?noticeId='+noticeId,
            width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
            name:"updateUI",
            title: "修改用户"
/*             , buttons: [
                <shiro:hasPermission name="user_update">                  
            { text: '保存', onclick: function(item, dialog) { window.frames["updateUI"].saveformSubmit();} },
                </shiro:hasPermission>
            { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
             ] */
        });
}


    // 进入界面加载                      
    $(function () {
        ligerManager = $("#t1").ligerGrid({ 
    	                                columns: [
    	                                            { display: "noticeId", 
    	                                      		   render: function(rowdata) {
    	                                    				return "<a style='text-decoration:none;color:#0000FF;' href=javascript:update2('"+ rowdata.noticeId +"')>" + rowdata.noticeId + "</a>";
    	                                   		   		}
    	                                            },
    	                                            { display: "标题", name: "title"},
    	                                            { display: "副标题", name: "title2"},
    	                                            { display: "公告时间", name: "noticeTime"},
    	                                            { display: "正文", name: "content"}
    	                                           ],
                            			url: "${ctx}/notice/findList.do",
                            			usePager: true,
                            			pageSize: 2,
                            			pageSizeOptions: [2,3,5,10],
                            			checkbox:true,
                            		    toolbar:{ items: [
                            	                             { text: "新增", icon: "add", click: add },
                            	                             { line: true },
                            	                             { text: "修改", icon: "add", click: update },
                            	                             { line: true },
                            	                         
                            	                             
                            	                     ]
                            	            },
                            			enabledSort:false,
                            			selectRowButtonOnly:true // 点复选框才勾选
                                      });
        ligerManager.loadData();
   })

	// 搜索
    function f_search() {
    	var queryArray=new Array();
   	    $("#searchbar").find("input[type=text],select").each(function(index){
   		     var object = new Object;  
   		     object.name=this.id;
   		     object.value=this.value;
   		     queryArray[index]=object;
   	    });
        parms=queryArray;
        
        ligerManager.set({
    	    parms:parms,
    	    page:1,
    	    newPage:1
        });
        ligerManager.loadData();
    }

  //重置
    function f_reset(){
    	$("#searchbar").find(":input").not(":button,:submit,:reset,:hidden").val("").removeAttr("checked").removeAttr("selected");
    }
</script>
