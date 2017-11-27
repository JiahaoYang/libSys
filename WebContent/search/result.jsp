<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, entity.*, dao.*"%>
<%
	request.setCharacterEncoding("utf8");
	
	String type = request.getParameter("searchType");
	String keyword = request.getParameter("keyword")==null ? "" : request.getParameter("keyword").trim();
	
	BookDao bookDao = new BookDao();
	List<Book> books = new ArrayList<>();
	
	if (type.equals("bookName"))
		books = bookDao.searchByName(keyword);
	else if (type.equals("isbn"))
		books = bookDao.searchByIsbn(keyword);
	else if (type.equals("press"))
		books = bookDao.searchByPress(keyword);
	
	int cnt = books.size();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xxx大学图书馆</title>
</head>
<body>
	<table align="center">
		<tr><td>检索到 <%=cnt%> 条关于 <%=keyword%> 的结果</td></tr>
		<tr>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>位置</td>
			<td>状态</td>
		</tr>
		<%
			for (Book book : books) {
		%>
		<tr>
			<td><%=book.getBookName()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getPress()%></td>
			<td><%=book.getPosition()%></td>
			<td><%=book.isBorrowed() ? "借出" : "可借"%></td>
		</tr>
		<%	} %>
		<tr><td><a href="./search.jsp">返回</a></td></tr>
	</table>
</body>
</html>