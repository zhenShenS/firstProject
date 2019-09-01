<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String base=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+base+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>" >
<title>jb-aptech毕业设计项目</title>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="script/common.js"></script>
<script src="js/changetrcolor.js" type="text/javascript"></script>
</head>
<body>
   <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<TD class="page_title">销售机会管理</TD>
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
					<a href="help.html"><input class="common_button" type="button"
						value="帮助"></a>&nbsp;&nbsp;&nbsp;
						<a href="sale/add_salchance_controller"><input class="common_button"
							type="button" value="新建"></a>
					 &nbsp;&nbsp; <input class="common_button" type="submit" value="查询">
				</td>
			</tr>
		</table>
	</form>
	<br />
	<table width="100%" cellSpacing=0 cellPadding=0>
		<tr>
			<TD width="247" class="page_title">检索结果</TD>
			<TD width="718" class="page_title_middle">&nbsp;</TD>
			<TD width=25><IMG height=32
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
			<th>操作</th>
		</tr>
		
		<c:forEach items="${findSalChance.list}" var="SalChance" varStatus="i">
		<tr>
				<td class="list_data_number">${SalChance.chcId}</td>
				<td class="list_data_text">${SalChance.chcCustName}</td>
				<td class="list_data_ltext">${SalChance.chcTitle}</td>
				<td class="list_data_text">${SalChance.chcLinkman}</td>
				<td class="list_data_text">${SalChance.chcTel}</td>
				<td class="list_data_op">
				
							<a
								href="sale/${SalChance.chcId}/dispatch_controller">
								<img title="指派"
								src="images/bt_linkman.gif"
								class="op_button" />
							</a>
					
							<a
								href="sale/${SalChance.chcId}/Update_controller">
								<img title="编辑"
								src="images/bt_edit.gif"
								class="op_button" />
							</a>

							<a
								href="sale/${SalChance.chcId}/delete_controller">
								<img title="删除"
								src="images/bt_del.gif"
								class="op_button" />
							</a>
							
							<!-- <img title="指派"
								src="images/bt_linkman.png"
								class="op_button" />
							<img title="编辑"
								src="images/bt_edit.png"
								class="op_button" />
							<img title="删除"
								src="images/bt_del.png"
								class="op_button" /> -->
			   </td>
			</tr>
		</c:forEach>
<%-- <tr>
			<th colspan="100" class="pager">共${sessionScope.storageAll.total}条记录
				每页 4 条 第页 <a href="cust/1/findAllCust">首页</a> <c:choose>
					<c:when test="${sessionScope.storageAll.hasPreviousPage}">
						<a href="cust/${sessionScope.storageAll.prePage}/findAllCust">上一页</a>
					</c:when>
					<c:otherwise>
						<font color="#ABA8AB">上一页</font>
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when test="${sessionScope.storageAll.hasNextPage}">
						<a href="cust/${sessionScope.storageAll.nextPage}/findAllCust">下一页</a>
					</c:when>
					<c:otherwise>
						<font color="#ABA8AB">下一页</font>
					</c:otherwise>
				</c:choose> <a href="cust/${sessionScope.storageAll.lastPage}/findAllCust">尾页</a>
			</th>
		</tr> --%>
		<tr>
			<th colspan="7" class="pager">共${sessionScope.findSalChance.total}
				<div class="pager">
					每页 4 条 第页 <a
						href="sale/1/showAllSaleChance">首页</a>
				<c:choose>
				   <c:when test="${sessionScope.findSalChance.hasNextPage}">
							<a href="sale/${sessionScope.findSalChance.nextPage}/showAllSaleChance">上一页</a>
				   </c:when>
					<c:otherwise>
							<font color="#ABA8AB">上一页</font>
					</c:otherwise>
				</c:choose>
					
                   <c:choose>
					<c:when test="${sessionScope.findSalChance.hasNextPage}">
						<a href="sale/${sessionScope.findSalChance.nextPage}/showAllSaleChance">下一页</a>
					</c:when>
					<c:otherwise>
						<font color="#ABA8AB">下一页</font>
					</c:otherwise>
					
					</c:choose> <a href="sale/${sessionScope.findSalChance.lastPage}/showAllSaleChance">尾页</a>
				</div>
			</th>
		</tr>
	</table>
</body>
</html>