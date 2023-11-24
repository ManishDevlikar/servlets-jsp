package com.validate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pass = req.getParameter("password");
		String p = "1234";
		PrintWriter ref = resp.getWriter();

		if (pass.equals(p)) {
			RequestDispatcher rd = req.getRequestDispatcher("/welcome");
			rd.forward(req, resp);
		} else {

			ref.print("<html><body><h1>Wrong Password</h1></body></html>");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}
}
