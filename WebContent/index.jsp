<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%
		String appPath = application.getContextPath();
	String filePath = application.getRealPath("index.jsp");
	%>
	웹 애플리케이션의 컨텍스트 패스명
	<br>
	<b><%=appPath%></b>
	<hr>
	웹 애플리케이션의 파일 경료명
	<br>
	<b><%=filePath%></b>
	<br>
	<hr>
	<ul>
	<%
	Enumeration<String> names = application.getInitParameterNames();
	while(names.hasMoreElements()){
		String param = names.nextElement();
		
		%>
		<li><%=param %> = <%=application.getInitParameter(param) %>
	<% 
	}
	%>
	</ul>
</body>
</html>