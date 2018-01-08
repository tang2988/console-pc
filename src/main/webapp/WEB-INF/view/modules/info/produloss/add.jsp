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
							style="margin-left:0px;">添加产品</span>
					</div>
				</td>
			</tr>


			<tr>
				<td align="right" class="l-table-edit-td">产品名称:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input  name="productName" type="text" id="productName"   /></td>
			</tr> 

			<tr>
				<td align="right" class="l-table-edit-td">预期年化金息:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="expectedAnnualizedInterestRate" type="text" id="expectedAnnualizedInterestRate"  /></td>
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">活动加息:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="activityPlusInterest" type="text" id="activityPlusInterest"  /></td>
			</tr>
			
			<tr>
				<td align="right" class="l-table-edit-td">起购金额:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="sumofMoneyPurchaseddecimal" type="text" id="sumofMoneyPurchaseddecimal"  /></td>
			</tr>
			
			<tr>
				<td align="right" class="l-table-edit-td">产品期限:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="productDeadline" type="text" id="productDeadline"  /></td>
			</tr>
			
			<tr>
				<td align="right" class="l-table-edit-td">状态:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="productStatus" type="text" id="productStatus"  /></td>
			</tr>

			
 

		</table>
	</form>

	<input type="button" value="保存" onclick="saveFrom()"
		style="background: #e0edff;"
		class="l-button l-button-submit vertical-center-user-defined" />

</body>
</html>

<script type="text/javascript">
        // 保存数据
        function saveFrom(){
        	$.post("${ctx}/productloss/add.do", $("#form1").serialize(), function (msg) { 
                if(msg=="true"){
                	$.ligerDialog.success("保存成功", "", function(){
                	     window.parent.ligerManager.loadData();
               	         window.parent.openWindow.close();
               	    });
                }
                else{
                	$.ligerDialog.error("保存失败");
                }
            });
            
        }
        
    </script>

