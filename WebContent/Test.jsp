<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javamysql.*" %>
<%
	String id = "cdy";
	String pw = "1234";
	ConnectMySql connect = ConnectMySql.getInstance();
	String returns = connect.connectionDB(id, pw);
			
	System.out.println("요청결과 : "+ returns);
%>