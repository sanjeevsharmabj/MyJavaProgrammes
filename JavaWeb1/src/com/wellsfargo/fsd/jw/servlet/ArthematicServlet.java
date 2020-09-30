package com.wellsfargo.fsd.jw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/arth")
public class ArthematicServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			int n1 = Integer.parseInt(req.getParameter("n1"));
			int n2 = Integer.parseInt(req.getParameter("n2"));
			
			String opt = req.getParameter("operation");
			
			String result="";
			
			switch(opt) {
			case "sum": result = "Sum of two number is "+(n1+n2);break;
			case "dif": result = "Difference of two number is "+(n1-n2);break;
			case "prd": result = "Product of two number is "+(n1*n2);break;
			case "qut": result = "Division of two number is "+(n1/n2);break;
			case "rem": result = "Reminder when two numbers are divided is "+(n1%n2);break;
			}
			
	
			resp.setContentType("text/html");
			
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h2>"+result+"</h2>");
			out.println("</body>");
			out.println("</html>");
			
		
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		doGet(req,resp);
		
	}

	
	
}
