package com.ty.genericApp;

//import com.mysql.jdbc.*;
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
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306?user=root&password=root5003";
		String fqcn = "com.mysql.jdbc.Driver";
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		try {

			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pstmt = con.prepareStatement("insert into studentinfo.student values(?,?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, age);
			pstmt.execute();
			System.out.println("inserted");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("systemmmm");
		PrintWriter ref = response.getWriter();
		ref.print("<html><body><h1>systemmm</h1></body></html>");
	}

}
