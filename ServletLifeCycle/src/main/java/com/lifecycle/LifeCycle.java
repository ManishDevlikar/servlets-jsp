package com.lifecycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class LifeCycle extends HttpServlet {
	public LifeCycle() {
		System.out.println("instantiation object Creation");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("object initilization");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("serice() called");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() called");
	}
}
