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
<base href="<%=basePath %>" >
<title>My JSP 'login.jsp' starting page</title>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="script/jquery-1.4.1.js"></script>
<script type="text/javascript">
	function userlogin() {
		$("#loginform").submit();
	}
</script> 
<style>
/* html{
	width:100%;
	height: 100%;
	background:url('images/login/background1.png');
	background-size: 100% 100%;
} */
th {
	font-size: 12px;
	text-align: right;
	font-weight: normal;
}

td {
	font-size: 12px;
	text-align: left;
}

input {
	width: 100px;
	font-size: 12px;
	border: solid 1px lightblue;
}
</style>
</head>
<body>
	<center>
		<div style="width: 1000; height: 100%; position: relative;">
			 <img
				style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; z-Index: -1; border: 1px solid blue;margin: 0px auto; "
				src="images/login/background1.png" /> 
			<TABLE WIDTH=100% height="100%">
				<tr>
					<td COLSPAN=2 ROWSPAN=2>
						<form action="sysUser/login" method="post" id="loginform">
							<table width="100%" height="100%">
								<tr>
								<td width="376" height="230"></td>
							 	<td width="305"></td>
								<td width="272"></td>  
								</tr>
								<tr>
									<td></td>
									<td><table width="79%">
											<tr>
												<th>用户名</th>
												<td><input size="30" name="username" maxlength="40" /></td>
											</tr>
											<tr>
												<th>密码</th>
												<td><input type="password" name="password" size="30"
													maxlength="40" /></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><img onclick="userlogin();"
													src="images/login/login.png"
													width="100" height="20"></td>
											</tr>
											<tr>
												<td height="36">&nbsp;</td>
												<td><font color="red" size="2"></font></td>
											</tr>
										</table></td>
									<td></td>
								</tr>
								<tr>
									<td height="158"></td>
									<td></td>
									<td></td>
								</tr>
							</table>

						</form>
					</td>
					<td COLSPAN=3 rowspan="2">&nbsp;</td>
					<td></td>
				</tr>

			</TABLE>
		</div>
	</center>
</body>
</html>