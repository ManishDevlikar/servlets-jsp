package com.school;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("pass");
		String username = req.getParameter("uname");
		PrintWriter ref = resp.getWriter();

		if (password.equals("1234") && username.equals("manish")) {
			ref.print("<html><body><h1>hii" + " " + username + "</h1></body></html>");
			RequestDispatcher rs = req.getRequestDispatcher("homePage.html");
			rs.include(req, resp);
		} else {

			ref.print("<html><body><h1>Invalid User</h1></body></html>");

			RequestDispatcher rs = req.getRequestDispatcher("login.html");
			rs.include(req, resp);
		}

	}
}
