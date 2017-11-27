<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xxx大学图书馆</title>
<script>
	function check() {
		var adminId = document.getElementsByName("adminId")[0].value;
		var password = document.getElementsByName("password")[0].value;
		if (adminId == "")
			alert("请输入工号!");
		else if (password == "")
			alert("请输入密码!");
		else
			document.forms[0].submit();
	}
</script>
</head>
<body>
	<form action="<%=path%>/AdminLogin" method="post">
	<table>
		<tr>
			<td>工号:</td>
			<td><input type="text" name="adminId"/></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td><input type="button" value="登录" onclick="check()" /></td>
		</tr>
	</table>
	</form>
	
<%
	String flag = request.getParameter("flag");
	if (flag != null && "error".equals(flag)) {
%>
<script>
	alert("用户名或密码错误!");
</script>
<%
	}
%>
</body>
</html>