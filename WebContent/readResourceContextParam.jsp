<%@page import="java.io.IOException"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 기본 객체를 사용하여 자원(resource) 읽기</title>
</head>
<body>
	<%
	
	String resourcePath = application.getInitParameter("noticePath");
	String str = "";
	try (BufferedReader br = new BufferedReader(
			new InputStreamReader(
					application.getResourceAsStream(resourcePath)))) {
		
		while ((str = br.readLine()) != null) {
			out.print(str);
		}
		
	} catch (IOException e) {
		out.print("예외 발생" + e.getMessage());
	}
	%>
</body>
</html>