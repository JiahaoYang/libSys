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
		var readerId = document.getElementsByName("readerId")[0];
		var password = document.getElementsByName("password")[0];
		var readerName = document.getElementsByName("readerName")[0];
		
		if (readerId == "")
			alert("请输入学号!");
		else if (password == "")
			alert("请输入密码!");
		else if (readerName == "")
			alert("请输入姓名");
		else 
			document.forms[0].submit();
	}
</script>
</head>
<body>
	<h1 align="center">读者添加</h1>
	<form action="<%=path%>/addReader" method="post">
	<table align="center">
		<tr>
			<td>学号：</td>
			<td><input type="text" name="readerId" /></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password" value="123456" /></td>
		</tr>
		<tr>
			<td>类型：</td>
			<td><select name="readerType">
				<option value="1">教师</option>
				<option value="2">研究生</option>
				<option value="3">本科生</option>
			</select></td>
		</tr>
		<tr>
			<td>名字：</td>
			<td><input type="text" name="readerName" /></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td><select name="gender">
				<option value="男">男</option>
				<option value="女">女</option>
			</select></td>
		</tr>
		<tr>
			<td>电话：</td>
			<td><input type="text" name="phone" /></td>
		</tr>
		<tr>
			<td>email：</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td><input type="button" value="提交" onclick="check()" /></td>
		</tr>
	</table>
	</form>
</body>
</html>