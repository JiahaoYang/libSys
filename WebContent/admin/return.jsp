<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xxx大学图书馆</title>
<script>
	function checkReturn() {
		var bookId = document.getElementsByName("bookId")[0].value;
		if (bookId == "")
			alert("请输入图书编号!");
		else
			document.forms[0].submit();
	}
</script>
</head>
<body>
	<form action="<%=path%>/returnBook" method="post">
	<table align="center">
		<tr>
			<td>图书编号：</td>
			<td><input type="text" name="bookId" /></td>
		</tr>
		<tr>
			<td><input type="button" value="归还" onclick="checkReturn()" /></td>
		</tr>
		<tr>
			<td><a href="./main.jsp">返回</a></td>
		</tr>
	</table>
	</form>
<%
	String flag = request.getParameter("flag");
	if ("noReader".equals(flag)) {
%>
	<script>
		alert("无此读者信息!");
	</script>
<%
	}
	else if ("fail".equals(flag)) {
%>
	<script>
		alert("还书失败!");
	</script>

<%
	}
%>
</body>
</html>