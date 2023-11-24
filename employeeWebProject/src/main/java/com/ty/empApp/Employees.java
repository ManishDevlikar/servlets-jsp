package com.ty.empApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Employees extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String eid = req.getParameter("eid");
		String ename = req.getParameter("ename");
		String esal = req.getParameter("esal");
		String erole = req.getParameter("erole");
		String fqcn = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=root5003";
		PrintWriter ref;
		Connection con;
		try {
			Class.forName(fqcn);
			con = DriverManager.getConnection(url);
			PreparedStatement pstmt = con.prepareStatement("insert into empinfo.emp values(?,?,?,?)");
			pstmt.setString(1, eid);
			pstmt.setString(2, ename);
			pstmt.setString(3, esal);
			pstmt.setString(4, erole);
			pstmt.execute();
			ref = res.getWriter();
			ref.print("<html><body><h1>details: " + eid + " " + ename + "" + esal + "" + erole + "</h1></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
