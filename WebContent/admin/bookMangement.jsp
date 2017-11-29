<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, entity.*, dao.*, util.*"%>
<%
	String path = request.getContextPath();
	BookDao bookDao = new BookDao();
	List<Book> books = bookDao.getAllBooks();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xxx大学图书馆-读者管理</title>
<script>
	function confirmDelete(bookId) {
		var okey = confirm("确认删除?");
		if (okey)
			window.location.href = "./deleteBook.jsp?bookId=" + bookId;
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>书名</td>
			<td>分类</td>
			<td>作者</td>
			<td>出版社</td>
			<td>位置</td>
			<td>状态</td>
			<td colspan="2">操作</td>
		</tr>
		<%
			for (Book book : books) {
		%>
		<tr>
			<td><%=book.getBookName()%></td>
			<td><%=book.getBookKind()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getPress()%></td>
			<td><%=book.getPosition()%></td>
			<td><%=CommonUtil.getBookState(book.isBorrowed())%></td>
			<td><input type="button" onclick="confirmDelete(<%=book.getBookId()%>)" value="删除" /></td>
		</tr>
		
		<%
			}
		%>
		<tr><td>
			<a href="./addBook.jsp">添加图书</a>
		</td></tr>
		<tr><td>
			<a href="./main.jsp">返回</a>
		</td></tr>
	</table>
	</body>
	</html>