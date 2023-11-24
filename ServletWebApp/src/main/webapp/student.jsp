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
		<%--To insert date into Student Table--%>
		<%
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try{
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			PreparedStatement pstmt = con.prepareStatement("insert into studentinfo.student values(?,?,?)");
			pstmt.setString(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,age);
			pstmt.execute();
			getServletContext().getRequestDispatcher("/NewFile.jsp").forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		%>
		
</body>
</html>