package com.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String studId = req.getParameter("sid");
		PrintWriter pw = resp.getWriter();
		String fqcn = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=root5003";
		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pstmt = con.prepareStatement("select * from studentinfo.student where id=" + studId + "");
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				pw.print(
						"<html><body><h2>Student table</h2><table border=1><tr><th>StudentId</th><th>StudentName</th><th>StudAge</th></tr><tr><td>"
								+ rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
								+ "</td></tr></table></body></html>");
			} else {
				pw.print("<html><body><h1>Invalid StudentId</h1></body></html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
