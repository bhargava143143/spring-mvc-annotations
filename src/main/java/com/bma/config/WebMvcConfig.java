package com.bma.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig {

	@Bean("viewWelcomeController")
	public Controller viewWelcomeAnnotationController() {
		ParameterizableViewController controller = null;
		controller = new ParameterizableViewController();
		controller.setViewName("wc-annot");

		return controller;
	}

	@Bean
	public HandlerMapping handlerMapping() {
		Properties mappings = null;
		SimpleUrlHandlerMapping simpleUrlHandlerMapping = null;

		mappings = new Properties();
		mappings.put("/welcome-annotation.htm", "viewWelcomeController");
		simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();

		simpleUrlHandlerMapping.setMappings(mappings);
		return simpleUrlHandlerMapping;
	}
	
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver internalResourceViewResolver = null;
		internalResourceViewResolver =  new InternalResourceViewResolver();
		
		internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
}
