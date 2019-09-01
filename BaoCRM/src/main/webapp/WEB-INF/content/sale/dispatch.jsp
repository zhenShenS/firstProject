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
<meta charset="UTF-8">
 <title>jb-aptech毕业设计项目</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/test1.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
  <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
<tr>
   <TD class="page_title">销售机会管理</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="images/m_mpr.gif" width=3></TD>
</tr>
</table>

<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
    	<td  width=100% height=30 align=left background = "images/m_table_top.jpg" colspan="6"><strong>&nbsp;指派销售机会</strong></td>
    </tr>
	<tr>
		<th>编号</th>
		<td>${oneSalChance.chcId}</td>
		<th>机会来源</th>
		<td>${oneSalChance.chcSource}</td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td>${oneSalChance.chcCustName}</td>
		<th>成功机率（%）</th>
		<td>${oneSalChance.chcRate}&nbsp;</td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3"><${oneSalChance.chcTitle}/td>
	</tr>
	<tr>
		<th>联系人</th>
		<td>${oneSalChance.chcLinkman}</td>
		<th>联系人电话</th>
		<td>${oneSalChance.chcTel}</td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3">${oneSalChance.chcDesc}</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td colspan="3">${oneSalChance.chcCreateBy}</td>
	</tr>
</table>
<br />

<form action="sale/dispatch_behind_controller"  method="post">
<table class="query_form_table" id="table1" cellSpacing=1 cellPadding=1>
	<tr>
    	<td  width=100% height=30 align=left background = "images/m_table_top.jpg" colspan="6"><strong>&nbsp;指派</strong></td>
    </tr>
	<tr>
	    <th>客户编号</th>
	    
		<td><input type="text" name="chcId" value="${oneSalChance.chcId}"/></td>
		<th>指派给</th>
		<td>
			<select name="chcDueTo"> 
			<option value="">请选择..</option>
			<c:forEach items="${sessionScope.findAllMgr}" var="Mgr">
				<option>${Mgr.usrName}</option>
			</c:forEach>
              <!-- 	 option value="">请选择..</option>
<c:forEach items="${sessionScope.allMgr}" var="allMgr">
<option value="${allMgr.usrName}"></option>
		</c:forEach> -->
			</select> <span class="red_star">*</span>
		   <select  disabled="disabled">
				<option>请选择...</option>
				</select>
		</td>
	</tr>
	
	<tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<a href="help.html"><input class="common_button"  type="button" value="帮助"></a>&nbsp;&nbsp;&nbsp;
			<input type="submit" value="保存/返回">
			 </td>
    </tr>
</table>
</form>
</body>
</html>