package com.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Performing pre-processing.........");
		// Perform all the pre-processing of request here
		/*........
		 * ......
		 * ........
		 * */
		chain.doFilter(request, response);
		// Perform all the post-processing of response here
		/*........
		 * ......
		 * ........
		 * */
		System.out.println("Perform post-processing......");
	}

	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
	
}
