package com.piggsoft.web;

import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextWebListener implements ServletContextListener {
  
    @Override  
    public void contextDestroyed(ServletContextEvent arg0) {
    }
  
    @Override  
    public void contextInitialized(ServletContextEvent sce) {  
        WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext())
                .getAutowireCapableBeanFactory().autowireBean(this);
        ServletContext context = sce.getServletContext();
        context.setAttribute("title", "测试网站");
    }
  
  
}