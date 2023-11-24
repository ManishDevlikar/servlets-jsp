package com.fetchApp;

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

@WebServlet("/fetch")
public class FetchData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String eid = req.getParameter("eid");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root5003");
			PreparedStatement pstmt = con.prepareStatement("select * from empinfo.emp where id = ?");
			pstmt.setString(1, eid);

			PrintWriter ref = res.getWriter();
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				ref.print(
						"<html><body><h2>Employee table</h2><table border=1><tr><th>EmpId</th><th>EmpName</th><th>EmpSal</th><th>EmpRole</th></tr><tr><td>"
								+ rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
								+ "</td><td>" + rs.getString(4) + "</td></tr></table></body></html>");
			} else {
				ref.print("<html><body><h1>invalid Id</h1></body></html>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
