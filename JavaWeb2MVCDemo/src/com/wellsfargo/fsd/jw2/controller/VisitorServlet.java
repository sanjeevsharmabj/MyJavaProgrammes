package com.wellsfargo.fsd.jw2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.jw2.model.VisitorModel;
import com.wellsfargo.fsd.jw2.service.VisitorService;

/**
 * Servlet implementation class VisitorServlet
 */
@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public VisitorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VisitorModel vmodel = new VisitorModel();
		vmodel.setTitle(request.getParameter("title"));
		vmodel.setFullName(request.getParameter("fnm"));
		vmodel.setGender(request.getParameter("gender"));
		
		VisitorService vs = new VisitorService();
		String greeting = vs.greet(vmodel);
		
		request.setAttribute("msg",greeting );
		RequestDispatcher rd = request.getRequestDispatcher("visitorInput.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
