<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javamysql.ConnectMySql" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String ddate = request.getParameter("ddate");
	
	ConnectMySql connect = ConnectMySql.getInstance();
	
	String returns = connect.write(title, content, ddate);
	out.print(returns);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>