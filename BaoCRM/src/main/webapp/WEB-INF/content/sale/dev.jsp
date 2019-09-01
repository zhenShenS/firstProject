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
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css"
	rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script src="js/changetrcolor.js"
	type="text/javascript"></script>
</head>
<body>
  <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<TD class="page_title">客户开发计划</TD>
			<TD class="page_title_middle">&nbsp;</TD>
			<TD width=3><IMG height=32
				src="images/m_mpr.gif" width=3></TD>
		</tr>
	</table>
	<form
		action=""
		method="post">
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<th>客户名称</th>
				<td><input type="text" name="chc_cust_name" /></td>
				<th>概要</th>
				<td><input type="text" name="chc_title" /></td>
				<th>联系人</th>
				<td><input type="text" name="chc_linkman" size="20" /></td>
			</tr>
			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<a href="help.html"><input
						class="common_button" type="button" value="帮助"></a>&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp; <input class="common_button" type="submit" value="查询">
				</td>
			</tr>
		</table>
	</form>
	<br />
	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
	<tr>
		<TD class="page_title">检索结果</TD>
		<TD class="page_title_middle">&nbsp;</TD>
		<TD width=3><IMG height=32
			src="images/m_mpr.gif" width=3></TD>
	</tr>
	</table>

	<table id="data_list_table" class="data_list_table" cellSpacing=1
		cellPadding=1>
		<tr>
			<th id="firstth">编号</th>
			<th>客户名称</th>
			<th>概要</th>
			<th>联系人</th>
			<th>联系人电话</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
<c:forEach items="${sessionScope.findSalChance.list}" var="fscb" varStatus="i">
<c:choose>
<c:when test="${fscb.chcStatus=='develop'}">
		<tr>
								<td class="list_data_number">${i.count}</td>
								<td class="list_data_text">${fscb.chcCustName}</td>
								<td class="list_data_ltext">${fscb.chcTitle}</td>
								<td class="list_data_text">${fscb.chcLinkman}</td>
								<td class="list_data_text">${fscb.chcTel}</td>
								<td class="list_data_text">${fscb.chcStatus}</td>

								<td class="list_data_op"><a
									href="sale/${fscb.chcId}/dev_plan_before"><img
										title="制定计划"
										src="images/bt_plan.gif"
										class="op_button" /></a> 
								</td>
							</tr>
</c:when>
<c:otherwise>
					<tr>
								<td class="list_data_number">${i.count}</td>
								<td class="list_data_text">${fscb.chcCustName}</td>
								<td class="list_data_ltext">${fscb.chcTitle}</td>
								<td class="list_data_text">${fscb.chcLinkman}</td>
								<td class="list_data_text">${fscb.chcTel}</td>
								<td class="list_data_text">${fscb.chcStatus}</td>


						<td class="list_data_op"><img
								onClick="to('sale/${fscb.chcId}/dev_plan_controller');"
								title="查看"
								src="images/bt_detail.gif"
								class="op_button" /></td>
					</tr>
</c:otherwise>
</c:choose>
</c:forEach>

		<tr>
			<th colspan="100" class="pager">共${sessionScope.findSalChance.total}条记录
				每页 8 条 第页 <a href="sale/1/dev">首页</a> <c:choose>
					<c:when test="${sessionScope.findSalChance.hasPreviousPage}">
						<a href="sale/${sessionScope.findSalChance.prePage}/dev">上一页</a>
					</c:when>
					<c:otherwise>
						<font color="#ABA8AB">上一页</font>
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when test="${sessionScope.findSalChance.hasNextPage}">
						<a href="sale/${sessionScope.findSalChance.nextPage}/dev">下一页</a>
					</c:when>
					<c:otherwise>
						<font color="#ABA8AB">下一页</font>
					</c:otherwise>
				</c:choose> <a href="sale/${sessionScope.findSalChance.lastPage}/dev">尾页</a>
			</th>
		</tr> 
	</table>
</body>
</html>