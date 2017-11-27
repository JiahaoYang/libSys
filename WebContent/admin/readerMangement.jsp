<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, entity.*, dao.*, util.*"%>
<%
	String path = request.getContextPath();
	ReaderDao readerDao = new ReaderDao();
	BorrowDao borrowDao = new BorrowDao();
	List<Reader> readers = readerDao.getAllReaders();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xxx大学图书馆-读者管理</title>
<script>
	function confirmSubmit(readerId) {
		var okey = confirm("确认删除?");
		if (okey)
			window.location.href = "./deleteReader.jsp?readerId=" + readerId;
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>类别</td>
			<td>可借</td>
			<td>已借</td>
			<td>超时</td>
			<td colspan="2">操作</td>
		</tr>
		<%
			for (Reader reader : readers) {
		%>
		<tr>
			<td><%=reader.getReaderId()%></td>
			<td><%=reader.getReaderName()%></td>
			<td><%=CommonUtil.getReaderType(reader.getReaderType())%></td>
			<td><%=CommonUtil.getAvailableCnt(reader.getReaderType())%></td>
			<td><%=borrowDao.getBorrowedCnt(reader.getReaderId())%></td>
			<td><%=borrowDao.getOverTimeCnt(reader.getReaderId())%></td>
			<td><input type="button" onclick="confirmSubmit(<%=reader.getReaderId()%>)" value="删除" /></td>
		</tr>
		
		<%
			}
		%>
		<tr><td>
			<a href="./addReader.jsp">添加读者</a>
		</td></tr>
	</table>
	</body>
	</html>