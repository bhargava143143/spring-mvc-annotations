package com.bma.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.bma.config.RootConfig;
import com.bma.config.WebMvcConfig;

public class AnnotationDispatcherServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext rootApplicationContext = null;
		AnnotationConfigWebApplicationContext servletApplicationContext = null;
		ContextLoaderListener contextLoaderListener = null;
		DispatcherServlet dispatcherServlet = null;

		rootApplicationContext = new AnnotationConfigWebApplicationContext();
		rootApplicationContext.register(RootConfig.class);

		contextLoaderListener = new ContextLoaderListener(rootApplicationContext);
		servletContext.addListener(contextLoaderListener);

		servletApplicationContext = new AnnotationConfigWebApplicationContext();
		servletApplicationContext.register(WebMvcConfig.class);
		dispatcherServlet = new DispatcherServlet(servletApplicationContext);

		ServletRegistration.Dynamic config = servletContext.addServlet("dispatcher", dispatcherServlet);
		config.addMapping("*.htm");
		config.setLoadOnStartup(2);

	}

}
