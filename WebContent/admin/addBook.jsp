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
		var bookName = document.getElementsByName("bookName")[0];
		var bookKind = document.getElementsByName("bookKind")[0];
		var author = document.getElementsByName("author")[0];
		var translator = document.getElementsByName("translator")[0];
		var isbn = document.getElementsByName("isbn")[0];
		var price = document.getElementsByName("price")[0];
		var press = document.getElementsByName("press")[0];
		var position = document.getElementsByName("position")[0];
		
		if (bookName == "")
			alert("请输入书名!");
		else if (bookKind == "")
			alert("请输入类别!");
		else if (author == "")
			alert("请输入作者!");
		else if (isbn == "")
			alert("请输入isbn!")
		else if (press == "")
			alert("请输入出版社");
		else if (position == "") 
			alert("请输入图书位置!");
		else
			document.forms[0].submit();
	}
</script>
</head>
<body>
	<h1 align="center">图书添加</h1>
	<form action="<%=path%>/addBook" method="post">
	<table align="center">
		<tr>
			<td>书名：</td>
			<td><input type="text" name="bookName" /></td>
		</tr>
		<tr>
			<td>分类：</td>
			<td><input type="text" name="bookKind" /></td>
		</tr>
		<tr>
			<td>作者：</td>
			<td><input type="text" name="author" /></td>
		</tr>
		<tr>
			<td>译者：</td>
			<td><input type="text" name="translator" /></td>
		</tr>
		<tr>
			<td>isbn：</td>
			<td><input type="text" name="isbn" /></td>
		</tr>
		<tr>
			<td>价格：</td>
			<td><input type="text" name="price" /></td>
		</tr>
		<tr>
			<td>出版社：</td>
			<td><input type="text" name="press" /></td>
		</tr>
		<tr>
			<td>位置：</td>
			<td><input type="text" name="position" /></td>
		</tr>
		<tr>
			<td><input type="button" value="提交" onclick="check()" /></td>
		</tr>
	</table>
	</form>
</body>
</html>