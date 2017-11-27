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
</head>
<body>
	<h1>书目检索</h1>
	<form action="./result.jsp" method="post">
	<table align="center">
		<tr>
			<td><select name="searchType">
				<option value="bookName">书名</option>
				<option value="isbn">isbn号</option>
				<option value="press">出版社</option>
			</select></td>
			<td>
				<input type="text" name="keyword" />
			</td>
			<td>
				<input type="submit" value="检索">
			</td>
		</tr>	
	</table>
	</form>
</body>
</html>