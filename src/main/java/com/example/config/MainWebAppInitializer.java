package com.example.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * A web-application initializer that implements the "WebApplicationInitializer" interface
 * This class replaces "web.xml" by setting up the "Spring context" and servlet manager programmatically.
 */
public class MainWebAppInitializer implements WebApplicationInitializer {

    /**
     * Web-application initialization method
     * Creates and configures the Spring root context and registers the servlet manager.
     *
     * @param servletContext servlet context
     * @throws ServletException in case of servlet initialization error
     */
    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext root =
                new AnnotationConfigWebApplicationContext();

        root.scan("com.example");
        servletContext.addListener(new ContextLoaderListener(root));

        ServletRegistration.Dynamic appServlet =
                servletContext.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}
