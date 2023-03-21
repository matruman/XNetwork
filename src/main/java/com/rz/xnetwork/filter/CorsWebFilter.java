package com.rz.xnetwork.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


@Component
@WebFilter
public class CorsWebFilter implements Filter{
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException { }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
          throws IOException, ServletException { 
          
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:3000"); 
    httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() { }
}
