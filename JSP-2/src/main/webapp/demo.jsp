<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style> 
#add{
color:gray;
}
#sub{
color:yellow;
}
#mul{
color:black
}
#div{
color:orangered;
}
p{
font-size:20px;
}
</style>
<body>
	<%
	int a=10;
	int b=2;
	int add=a+b;
	int sub=a-b;
	int mul=a*b;
	int div=a/b;
	Date d=new Date();
	%>
	<p id="add">addition:= <%=add%></p>
	<p id="sub">subtraction:=<%=sub%></p>
	<p id="mul">multiplication:=<%=mul%></p>
	<p id="div">division:=<%=div%></p>
	<%=d %>
	<p>Thank You</p>
	
</body>
</html>