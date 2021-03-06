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
 <title>编辑联系人</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script src="script/common.js"></script>
	<script src="script/jquery-1.4.1.js"></script>
	<script src="js/linkman_edit.js"></script>
</head>
<body>
 <div class="page_title">客户信息管理 &gt; 客户信息 &gt; 联系人 &gt; 编辑联系人</div>
<form action="controller/linkMan_update_behind" method="post" id="updatelkmform">
<div class="button_bar">
	<a href="help.html"><input class="common_button"  type="button" value="帮助"></a>
	<a href="list.html"><button class="common_button" type="submit">保存/返回</button></a>
</div>
<input type="hidden" name="lkm_id" value=""/>
<input type="hidden" name="lkm_cust_id" value="" />
<input type="hidden" name="lkm_cust_no" value=""/>
<input type="hidden" name="lkm_cust_name" value=""/>
<table class="query_form_table" id="table1">
	<tr>
		<th>工号</th>
		<td><input  name="lkmId" value="${sessionScope.updateLinkManById.lkmId}" size="20" id="lkmId"/><span class="red_star" id="lkm_nameinpspan">*</span></td>
		<th>姓名</th>
		<td><input  name="lkmName" value="${sessionScope.updateLinkManById.lkmName}" size="20" id="lkmName"></<input><span class="red_star" id="lkm_nameinpspan">*</span></td>
		<th>性别</th>
		<td>
			<input type="radio" name="lkmSex" value="男" checked />男
			<input type="radio" name="lkmSex" value="女" />女
		</td>
	</tr>
	<tr>
		<th>职位</th>
		<td><input name="lkmPostion" value="${sessionScope.updateLinkManById.lkmPostion}" size="20" id="lkmPostion"></<input><span class="red_star" id="lkm_postionspan">*</span></td>
		<th>手机</th>
		<td><input name="lkmTel" value="${sessionScope.updateLinkManById.lkmTel}" size="20" id="lkmTel"/></<input><span class="red_star" id="lkm_telspan">*</span></td>
		<th>客户Id</th>
		<td><input name="lkmCustId" value="${sessionScope.updateLinkManById.lkmCustId}" size="20" id="lkmCustId"/></<input><span class="red_star" id="lkm_telspan">*</span></td>
	</tr>	
	<tr>
		<th>办公电话</th>
		<td><input name="lkmMobile" value="${sessionScope.updateLinkManById.lkmMobile}" size="20" ></<input></td>
		<th>备注</th>
		<td><input name="lkmMemo" value="${sessionScope.updateLinkManById.lkmMobile}" size="20" ></<input></td>
		<th>顾客名字</th>
		<td><input name="lkmCustName" value="${sessionScope.updateLinkManById.lkmCustName}" size="20" ></<input></td>
	</tr>
</table>
</form>
</body>
</html>