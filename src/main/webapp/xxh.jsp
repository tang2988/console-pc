<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ include file="include/head.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xxh.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <div class="liger-treegrid" id="treegrid1" data="CustomersData" enabledEdit="true">
         <ul class="liger-treegrid-columns">
             <li name="CustomerID" width="200">CustomerID 
                      <input class="liger-treegrid-editor" ltype="text" />
             </li>
             <li name="CompanyName" width="200">CompanyName
                     <input class="liger-treegrid-editor" ltype="date" data-property="type:'checkbox'" />
             </li>
             <li display="Address">
                 <ul class="liger-treegrid-columns">
                     <li name="City" width="100">City</li>
                     <li name="Address" width="100">Address</li>
                     <li name="PostalCode" width="100">PostalCode</li>
                 </ul>
             </li>
         </ul>
         <div class= "liger-treegrid-detail"></div>
      </div> 
  </body>
</html>
