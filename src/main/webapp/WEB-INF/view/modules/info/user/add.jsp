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
							style="margin-left:0px;">添加会员</span>
					</div>
				</td>
			</tr>
			
			
			
			<tr>
				<td align="right" class="l-table-edit-td">真实姓名:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="RealName" type="text" id="RealName" value="${map.realName}" />
					
					</td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">登录密码:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="Password" type="text" id="Password" value="${map.password}" />
					
					</td>
			</tr>
			
				<tr>
				<td align="right" class="l-table-edit-td">交易密码:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="transactionPwd" type="text" id="transactionPwd"  value="${map.transactionPwd}"/>
					
					</td>
			</tr>
				<tr>
				<td align="right" class="l-table-edit-td">手机号码:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="mobilePhone" type="text" id="mobilePhone" value="${map.mobilePhone}" />
					
					</td>
			</tr>
				<tr>
				<td align="right" class="l-table-edit-td">账户状态:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="UserStatus" type="text" id="UserStatus" value="${map.userStatus}" />
					
					</td>
			</tr>
				<tr>
				<td align="right" class="l-table-edit-td">身份证号码:&nbsp;&nbsp;<span
					style="color:red;">*</span></td>
				<td align="left" class="l-table-edit-td"><input name="idcardNo" type="text" id="idcardNo" value="${map.idcardNo}" />
					
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
        	$.post("${ctx}/User/add.do", $("#form1").serialize(), function (msg) { 
                if(msg=="true"){
                	$.ligerDialog.success("添加成功", "", function(){
                		window.parent.ligerG.loadData();
              	         window.parent.ligerDG.close();
               	    });
                }
                else{
                	$.ligerDialog.error("保存失败");
                }
            });
            
        }
        
    </script>

