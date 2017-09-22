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
							style="margin-left:0px;">产品信息</span>
					</div>
				</td>
			</tr>
			
			<tr>
				<td align="right" class="l-table-edit-td">产品ID:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="productId" type="text" id="productId" value="${json.productId}" />
					
					</td>
			</tr>	
			
			<tr>
				<td align="right" class="l-table-edit-td">产品类型:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="productType" type="text" id="productType" value="${json.productType}" />
					
					</td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">克重:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="gramWeight" type="text" id="gramWeight" value="${json.gramWeight}" />
					
					</td>
			</tr>
			
				<tr>
				<td align="right" class="l-table-edit-td">品牌:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="brand" type="text" id="brand"  value="${json.brand}"/>
					
					</td>
			</tr>
				<tr>
				<td align="right" class="l-table-edit-td">产品价格:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="productPrice" type="text" id="productPrice" value="${json.productPrice}" />
					
					</td>
			</tr>
				<tr>
				<td align="right" class="l-table-edit-td">库存:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="bepertory" type="text" id="bepertory" value="${json.bepertory}" />
					
					</td>
			</tr>
				<tr>
				<td align="right" class="l-table-edit-td">详情页:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="detailpage" type="text" id="detailpage" value="${json.detailpage}" />
					
					</td>
			</tr>
				<tr>
				<td align="right" class="l-table-edit-td">产品名称:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="productName" type="text" id="productName" value="${json.productName}" />
					
					</td>
			</tr>
				<tr>
				<td align="right" class="l-table-edit-td">状态:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="productStatus" type="text" id="productStatus" value="${json.productStatus}" />
					
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
        	$.post("${ctx}/produ/update.do", $("#form1").serialize(), function (msg) { 
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
        
    </script>

