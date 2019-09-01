<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String base=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+base+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" >
<meta charset="UTF-8">
<title>My JSP 'activities_edit.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css"
	rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript"
	src="script/jquery-1.4.1.js"></script>
<script type="text/javascript"
	src="js/activities_add.js"></script>
</head>
<body>
  <div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录 &gt; 编辑交往记录</div>
	<form
		action="controller/Communication_edit_behind"
		method="post" >
		<div class="button_bar">
			<a href="help.html"><input class="common_button" type="button"
				value="帮助"></a>
			<button class="common_button" type="submit">保存/返回</button>
		</div>
	<!--    <input type="hidden"
			name="atv_cust_id" value=" " /> -->
		
		
		
		<table class="query_form_table" id="table1">
		
		
			<tr>
				<th>客户id</th>
				<td><input type="text" name="atvId"
			         value="${CstActivityById.atvId}"size="20" /> <span class="red_star" id="atv_placespan">*</span></td>
				<th>客户编号</th>
				<td><input type="text" name="atvCustNo"
			         value="${CstActivityById.atvCustNo}" size="20"/> <span class="red_star" id="atv_placespan">*</span></td>
			</tr>
			<tr>
				<th>客户名</th>
				<td><input type="text" name="atvCustName"
			         value="${CstActivityById.atvCustName}" size="20"/> <span class="red_star" id="atv_placespan">*</span></td>
				<th>地点</th>
				<td><input name="atvPlace"
					value="${CstActivityById.atvPlace}" size="20"
					id="atvPlace" /><span class="red_star" id="atv_placespan">*</span></td>
			</tr>
			<tr>
				<th>概要</th>
				<td><input name="atvTitle"
				    value="${CstActivityById.atvTitle}" size="20"
					id="atvTitle" /><span class="red_star" id="atv_titlespan">*</span></td>
				<th>备注</th>
				<td><input name="atvDesc" size="20"
				    value="${CstActivityById.atvDesc}"
					 /></td>
			</tr>
		</table>
	</form>
</body>
</html>