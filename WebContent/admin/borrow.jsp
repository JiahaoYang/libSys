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
	function checkBorrow() {
		var bookId = document.getElementsByName("bookId")[0].value;
		var readerId = document.getElementsByName("readerId")[0].value;
		if (bookId == "")
			alert("请输入图书编号!");
		else if (readerId == "")
			alert("请输入学号!")
		else
			document.forms[0].submit();
	}
</script>
</head>
<body>
	<form action="<%=path%>/borrow" method="post">
	<table align="center">
		<tr>
			<td>图书编号：</td>
			<td><input type="text" name="bookId" /></td>
		</tr>
		<tr>
			<td>学号：</td>
			<td><input type="text" name="readerId" /></td>
		</tr>
		<tr>
			<td><input type="button" value="借阅" onclick="checkBorrow()" /></td>
		</tr>
		<tr>
			<td><a href="./main.jsp">返回</a></td>
		</tr>
	</table>
	</form>
<%
	String flag = request.getParameter("flag");
	if ("noBook".equals(flag)) {
%>
	<script>
		alert("图书信息不存在!");
	</script>
<%
	}
	else if ("noReader".equals(flag)) {
%>
	<script>
		alert("读者信息不存在!");
	</script>
<%
	}
	else if ("fail".equals(flag)) {
%>
	<script>
		alert("借阅失败!");
	</script>
<%
	}
	else if ("success".equals(flag)){
%>
	<script>
		alert("借阅成功!");
	</script>
<%
	}
%>
</body>
</html>