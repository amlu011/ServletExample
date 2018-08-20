<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Data Page</title>
</head>
<body> 
<table border="1" width="303">
<tr>
<td width="119"><b>ID</b></td>
<td width="168"><b>Message</b></td>
</tr>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import="java. util.Iterator"%>
<%@ page import="com.test.User"%>

<%
List<User> dataList= (List<User>)request.getAttribute("data");
for(User user:dataList){

	int u_id=user.getU_id();
	
	String name =user.getName();%>
	<tr>
	<td width="119"><a href ="DisplayServlet?u_id=<%=u_id%>"><%=u_id%></a></td>
	<td width="168"><%=name%></td>
	

	</tr>

<%}%>
</table>



</body>
</html>




	





