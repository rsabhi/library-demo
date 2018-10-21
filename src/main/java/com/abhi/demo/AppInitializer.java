package com.abhi.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class AppInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext webApplicationContext =
        new AnnotationConfigWebApplicationContext();
    webApplicationContext.register(AppConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
    servletContext.addServlet("dispatcherServlet", dispatcherServlet).addMapping("/");
  }
}
