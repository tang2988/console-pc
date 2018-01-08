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

            
           
function add() {
  openWindow=$.ligerDialog.open({
            url: '${ctx}/Announcement/addAc', 
            width: 900, height:700, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true, 
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
	
	 var sj = rows[0];
	 console.info(sj);
	var announcementId = sj.announcementId;
	
       openWindow=$.ligerDialog.open({
            url: '${ctx}/Announcement/update.html?announcementId='+announcementId,
            width: 600, height:500, showMax: true, showToggle: true, showMin: true, isResize: true, modal: true,
            name:"updateUI",
            title: "修改公告"
/*             , buttons: [
                <shiro:hasPermission name="user_update">                  
            { text: '保存', onclick: function(item, dialog) { window.frames["updateUI"].saveformSubmit();} },
                </shiro:hasPermission>
            { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
             ] */
        });
}


//修改用户
function update2(announcementId) {
       openWindow=$.ligerDialog.open({
            url: '${ctx}/Announcement/update.html?announcementId='+announcementId,
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
    	                                            { display: "announcementId", 
    	                                      		   render: function(rowdata) {
    	                                    				return "<a style='text-decoration:none;color:#0000FF;' href=javascript:update2('"+ rowdata.announcementId +"')>" + rowdata.announcementId + "</a>";
    	                                   		   		}
    	                                            },
    	                                            { display: "标题", name: "title"},
    	                                            { display: "内容", name: "content"},
    	                                            { display: "图片地址", name: "imageruri",render:function(ig){
    	                                            	return "<img src='"+ig.imageruri+"'/>"
    	                                            	
    	                                            }},
    	                                           ],
                            			url: "${ctx}/Announcement/findAllpg.do",
                            			usePager: true,
                            			pageSize: 3,
                            			pageSizeOptions: [5,10,20],
                            			checkbox:true,
                            		    toolbar:{ items: [
                            	                             { text: "新增公告", icon: "add", click: add },
                            	                             { line: true },
                            	                             { text: "修改公告", icon: "add", click: update },
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
