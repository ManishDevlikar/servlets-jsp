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
	<h1>Hello Aliens</h1>
	<%-- Date Object --%>
	<%

 String id=request.getParameter("eid");
 String name=request.getParameter("ename");
 String sal=request.getParameter("esal");
 String erole=request.getParameter("erole");
 
 String fqcn="com.mysql.jdbc.Driver";
 String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
 try{
	 
 	Class.forName(fqcn);
 	Connection con=DriverManager.getConnection(url);
 
 	PreparedStatement pstmt=con.prepareStatement("insert into empinfo.emp values(?,?,?,?)");
 	pstmt.setString(1,id);
 	pstmt.setString(2,name);
 	pstmt.setString(3,sal);
 	pstmt.setString(4,erole);
 	pstmt.execute();
 }catch(Exception e){
	 e.printStackTrace();
 }
	%>
		<p> <%=id %></p>
			<p> <%=name %></p>
				<p> <%=sal %></p>
					<p> <%=erole %></p>
					

</body>
</html>