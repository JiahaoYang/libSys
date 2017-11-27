<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%
	request.setCharacterEncoding("utf8");
	String readerId = request.getParameter("readerId").trim();
	ReaderDao readerDao = new ReaderDao();
	boolean success = readerDao.deleteReader(readerId);
	if (success) {
%>
<script>
	alert("删除成功!");
	window.location.href = "./readerMangement.jsp";
</script>
<%
	}
	else {
%>
<script>
	alert("删除失败!");
	window.location.href = "./readerMangement.jsp";
</script>
<%
	}
%>
