package edu.mum.waa.lab02.prob01;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter pw = resp.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Calculator</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<form action=\"\" method=\"post\">");
		sb.append("<input type=\"number\" name=\"num1\" />+<input type=\"number\" name=\"num2\" /> = <input type=\"number\" name=\"sum\" />");
		sb.append("<br />");
		sb.append("<input type=\"number\" name=\"num3\" />+<input type=\"number\" name=\"num4\" /> = <input type=\"number\" name=\"multiply\" />");
		sb.append("<br />");
		sb.append("<input type=\"submit\" value=\"submit\" />");
		sb.append("</form>");
		sb.append("</body>");
		sb.append("</html>");
		pw.write(sb.toString());
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
		
		PrintWriter pw = resp.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Calculator</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<form action=\"\" method=\"post\">");
		sb.append(String.format("<input type=\"number\" name=\"num1\" value=\"%s\"/>+", num1)
				+ String.format("<input type=\"number\" name=\"num2\" value=\"%s\"/> = ", num2)
				+ String.format("<input type=\"number\" name=\"sum\" value=\"%s\"/>", sum));
		sb.append("<br />");
		sb.append(String.format("<input type=\"number\" name=\"num3\" value=\"%s\"/>*", num3)
				+ String.format("<input type=\"number\" name=\"num4\" value=\"%s\"/> = ", num4)
				+ String.format("<input type=\"number\" name=\"multiply\" value=\"%s\"/>", multiply));
		sb.append("<br />");
		sb.append("<input type=\"submit\" value=\"submit\" />");
		sb.append("</form>");
		sb.append("</body>");
		sb.append("</html>");
		pw.write(sb.toString());
	}
}
