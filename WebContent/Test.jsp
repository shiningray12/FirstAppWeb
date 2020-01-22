<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javamysql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	
	String pwd = request.getParameter("pwd");
	String type = request.getParameter("type");
	
	ConnectMySql connect = ConnectMySql.getInstance();
	
	if(type.equals("login")){
		String returns = connect.logindb(id, pwd);
		out.print(returns);
	}else if(type.equals("join")){
		String returns = connect.joindb(id, pwd);
		out.print(returns);
	}
	
%>