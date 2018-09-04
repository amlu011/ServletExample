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
<td width="119"><b>TODO_ID</b></td>
<td width="168"><b>Message</b></td>
<td width="168"><b>USER_ID</b></td>
<%!  
    int value;  
%>  
</tr>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import="java. util.Iterator"%>
<%@ page import="com.test.Todo"%>

<%Object value; %>
<%int user_id=0; %>
<% List<Todo> dataList= (List)request.getAttribute("data");

for(Todo todo:dataList){
	
	int tid=todo.getT_id();
	
	String name =todo.getTodo();
	user_id=todo.getUser_id();
	
	%>
	<tr>
	<td width="119"><%=tid%></td>
	<td width="168"><%=name%></td>
	<td width="168"><%=user_id%></td>





	</tr>
	<%}%>

</table>







<form action="InsertServlet">
<table>
<tr> 
<td width="60"><b>TODO Message</b></td>
<td>
<input type="text" name="todo"></td>
<td>
<input type="hidden"  value=<%=user_id %> name="userId"></td>


<td><button type="submit" name ="Add TODO">Add TODO</button></td>




</table>


</form>

<form action="HomeServlet">

<td><button  type="Submit" name ="Home">Home</button></td>

</form>

</body>
</html>