package com.wellsfargo.fsd.jw3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/todos")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public TodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*using sessions below*/
		HttpSession session = request.getSession();
		List<String> tasklist = (List<String>)session.getAttribute("tasks");
		
		/*using context*/
		//ServletContext context = getServletContext();
		//List<String> tasklist = (List<String>)context.getAttribute("tasks");
		
		/*using request will overwrite when ever a new task is added and the form submitted the previous
		* task will be lost*/
		
		//List<String> tasklist = (List<String>)request.getAttribute("tasks");
		if (tasklist==null) {
			tasklist = new ArrayList<>();
		}
		
		String task = request.getParameter("task");
		
		if (task!=null) {
			tasklist.add(task);
		}
		
		session.setAttribute("tasks", tasklist);
		//context.setAttribute("tasks", tasklist);
		request.getRequestDispatcher("todoPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
