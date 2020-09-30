package com.wellsfargo.fsd.jw3.filter;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ExecutionTimeFilter
 */
@WebFilter("/*")
public class ExecutionTimeFilter implements Filter {

   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		LocalDateTime starttime = LocalDateTime.now();
		chain.doFilter(request, response);
		LocalDateTime endtime = LocalDateTime.now();
		System.out.println("it took "+Duration.between(starttime, endtime).toNanos()+"ns to respond");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
