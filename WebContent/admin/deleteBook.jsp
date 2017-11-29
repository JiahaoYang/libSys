<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%
	request.setCharacterEncoding("utf8");
	int bookId = Integer.parseInt(request.getParameter("bookId").trim());
	BookDao bookDao = new BookDao();
	boolean success = bookDao.deleteBook(bookId);
	if (success) {
%>
<script>
	alert("删除成功!");
	window.location.href = "./bookMangement.jsp";
</script>
<%
	}
	else {
%>
<script>
	alert("删除失败!");
	window.location.href = "./bookMangement.jsp";
</script>
<%
	}
%>
