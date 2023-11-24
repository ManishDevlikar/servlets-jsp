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
	<%	String id=request.getParameter("eid");
		String fqcn="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
		
		try{
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			PreparedStatement pstmt=con.prepareStatement("select * from empinfo.emp where id=?");
			pstmt.setString(1,id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				out.print("<html><body><h2>Employee table</h2><table border=1><tr><th>EmpId</th><th>EmpName</th><th>EmpSal</th><th>EmpRole</th></tr><tr><td>"
						+ rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td></tr></table></body></html>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>