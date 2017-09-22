<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>

<%@ include file="../../../include/head.jsp"%>

<link href="${ctxStatic}/ligerUI/lib/ligerUI/skins/Gray/css/all.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	font-size: 12px;
}

.l-table-edit {
	
}

.l-table-edit-td {
	padding: 4px;
}

.l-button-submit,.l-button-test {
	width: 80px;
	float: left;
	margin-left: 10px;
	padding-bottom: 2px;
}

.l-verify-tip {
	left: 230px;
	top: 120px;
}
</style>

</head>

<body style="padding:10px">

	<form name="form1" method="post" action="" id="form1">
		<div></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">

			<tr>
				<td colspan="4">
					<div class="l-group l-group-hasicon">
						<img
							src="${ctxStatic}/ligerUI/lib/ligerUI/skins/icons/communication.gif"><span
							style="margin-left:0px;">添加新闻信息</span>
					</div>
				</td>
			</tr>	
			
			<tr>
				<td align="right" class="l-table-edit-td">图片:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td">
				<!-- <input type="file" id="image" name="image" onchange="upload()"><br/> -->
				
				<input name="picture" type="text" id="picture"  />
					
					</td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">内容:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="content" type="text" id="content"  />
					
					</td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">标题:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="title" type="text" id="title" />
					
					</td>
			</tr>
			
			


		</table>
		
		<input type="button" value="保存" onclick="ssaveFrom()"
		style="background: #e0edff;"
		class="l-button l-button-submit vertical-center-user-defined" />
	</form>
	
	

</body>
</html>

<script type="text/javascript">


        // 保存数据
        function ssaveFrom(){
        	$.post("${ctx}/mediaa/add.do", $("#form1").serialize(), function (msg) { 
                if(msg=="true"){
                	$.ligerDialog.success("添加成功", "", function(){
                		window.parent.ligerManager.loadData();
              	         window.parent.openWindow.close();
               	    });
                }
                else{
                	$.ligerDialog.error("保存失败");
                }
            });
            
        }
        
        function upload(){
        	var formdata=new FormData($("#form1")[0]);//获取文件法一
        	//var formdata=new FormData( ); 
        	//formdata.append("file" , $("#file")[0].files[0]);//获取文件法二
        	       $.ajax({
        	           type : 'post',
        	           url : 'upload.do',
        	           data : formdata,
        	           cache : false,
        	           processData : false, // 不处理发送的数据，因为data值是Formdata对象，不需要对数据做处理
        	           contentType : false, // 不设置Content-type请求头
        	           dataType:"json",
        	           success : function(d){
        	        	   if(d.isOk==true){
        	        		   $("#picture").val(d.acessUrl);
        	        	   }else{
        	        		   $.ligerDialog.error("上传失败");
        	        	   }
        	           }
        	       })
        }
        
    </script>

