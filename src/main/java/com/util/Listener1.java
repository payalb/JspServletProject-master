package com.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class  Listener1 implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println(sce.getServletContext());
	}
}

class Listener2 implements ServletRequestListener{
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest req=(HttpServletRequest) sre.getServletRequest();
		System.out.println("Request received for"+req.getRequestURI());
	}
}