<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String fqcn="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
	String id=request.getParameter("nm");
	String name=request.getParameter("sn");
	String age=request.getParameter("age");
	try{		
	Class.forName(fqcn);
	Connection con = DriverManager.getConnection(url);
	PreparedStatement pstmt=con.prepareStatement("insert into studentinfo.student values(?,?,?)");
	pstmt.setString(1,id);
	pstmt.setString(2,name);
	pstmt.setString(3,age);
	pstmt.execute();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	%>
</body>
</html>