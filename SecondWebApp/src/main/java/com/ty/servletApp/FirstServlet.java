package com.ty.servletApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String fid = arg0.getParameter("nm");
		String sname = arg0.getParameter("sn");
		String age = arg0.getParameter("age");
		String fqcn = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=root5003";
		PrintWriter ref = arg1.getWriter();
		ref.print("<html><body><h1>details: " + fid + " " + sname + "" + age + "</h1></body></html>");
		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);

			PreparedStatement pstmt = con.prepareStatement("insert into studentinfo.student values(?,?,?)");
			pstmt.setString(1, fid);
			pstmt.setString(2, sname);
			pstmt.setString(3, age);
			pstmt.execute();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
