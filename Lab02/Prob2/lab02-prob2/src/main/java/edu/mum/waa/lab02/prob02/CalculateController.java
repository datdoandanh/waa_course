package edu.mum.waa.lab02.prob02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@
	Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("calculator.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1, num2, num3, num4, sum = "", multiply = "";
		num1 = req.getParameter("num1");
		num2 = req.getParameter("num2");
		num3 = req.getParameter("num3");
		num4 = req.getParameter("num4");
		
		try {
			int a1 = Integer.parseInt(num1);
			int a2 = Integer.parseInt(num2);
			sum = String.valueOf(a1 + a2);
		} catch(NumberFormatException e) {
			
		}
		
		try {
			int a3 = Integer.parseInt(num3);
			int a4 = Integer.parseInt(num4);
			multiply = String.valueOf(a3 * a4);
		} catch(NumberFormatException e) {
			
		}
		RequestDispatcher rd = req.getRequestDispatcher("calculator.jsp");
		req.setAttribute("num1", num1);
		req.setAttribute("num2", num2);
		req.setAttribute("num3", num3);
		req.setAttribute("num4", num4);
		req.setAttribute("sum", sum);
		req.setAttribute("multiply", multiply);
		rd.forward(req, resp);
	}
}
