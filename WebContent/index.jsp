<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 
						request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xxx大学图书馆</title>
</head>
<body>
	<table align="center">
		<tr><td>
			<a href="<%=path%>/search/search.jsp">书目检索</a>
		</td></tr>
		<tr><td>
			<a href="<%=path%>/reader/login.jsp">我的图书馆</a>
		</td></tr>
		<tr><td>
			<a href="<%=path%>/admin/login.jsp">管理员登录</a>
		</td></tr>
	</table>
</body>
</html>