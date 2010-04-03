package bookshelf.frontend.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import bookshelf.core.context.ApplicationContextHolder;

public class ApplicationContextInitializer implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent event) {
		ApplicationContextHolder.initialize(WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()));
	}

}
