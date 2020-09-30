package com.wellsfargo.fsd.cvp.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Loginfilter
 */
@WebFilter("/adminLogin")
public class Loginfilter implements Filter {

   
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		if (user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			chain.doFilter(request, response);
			
		} else {
			request.setAttribute("errMsg", "Login Failed!! Incorrect Username or Password");
			request.getRequestDispatcher("errorPage.jsp").forward(request, response);
		}
		
	}
		


	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
