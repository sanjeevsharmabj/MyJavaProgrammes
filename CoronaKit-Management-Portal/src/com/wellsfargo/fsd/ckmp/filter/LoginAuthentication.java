package com.wellsfargo.fsd.ckmp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
@WebFilter("/login")
public class LoginAuthentication implements Filter {

	@Override
	public void destroy() {	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String username = request.getParameter("userName");
	    String password = request.getParameter("password");
		if ((username.equalsIgnoreCase("admin")) && (password.equalsIgnoreCase("admin"))) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("errMsg", "Incorrect Username and Password, Could not Login!");
			request.getRequestDispatcher("errorPage.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
