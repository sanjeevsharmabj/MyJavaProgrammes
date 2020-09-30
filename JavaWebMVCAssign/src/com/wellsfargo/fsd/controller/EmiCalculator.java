package com.wellsfargo.fsd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.model.EmiModel;
import com.wellsfargo.fsd.service.EmiService;


/**
 * Servlet implementation class EmiCalculator
 */
@WebServlet("/emis")
public class EmiCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmiModel emi = new EmiModel();
		emi.setPrincipal(Double.parseDouble(request.getParameter("principal")));
		emi.setDuration(Integer.parseInt(request.getParameter("duration")));
		emi.setRoi(Double.parseDouble(request.getParameter("roi")));
		
		EmiService emiService = new EmiService();
		emiService.computeEMI(emi);
		
		request.setAttribute("model1", emi);
		RequestDispatcher rd = request.getRequestDispatcher("emiAmount.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
