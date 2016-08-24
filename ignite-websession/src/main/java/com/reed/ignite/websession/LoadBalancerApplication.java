package com.reed.ignite.websession;

import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.ignite.cache.websession.WebSessionFilter;
import org.apache.ignite.startup.servlet.ServletContextListenerStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @ImportResource({"classpath*:META-INF/app-ignite.xml"})
public class LoadBalancerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(
				LoadBalancerApplication.class, args);
		// Ignition.start(app.getBean(IgniteConfiguration.class));
	}

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		super.onStartup(servletContext);
	}

	@Bean
	public ServletContextListenerStartup servletContextListenerStartup() {
		ServletContextListenerStartup servletContextListenerStartup = new ServletContextListenerStartup();
		return servletContextListenerStartup;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		WebSessionFilter webSessionFilter = new WebSessionFilter();
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(webSessionFilter);
		registrationBean.setUrlPatterns(Arrays.asList("/*"));

		return registrationBean;
	}

}
