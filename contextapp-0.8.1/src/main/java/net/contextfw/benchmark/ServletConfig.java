package net.contextfw.benchmark;

import javax.servlet.ServletContextEvent;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class ServletConfig extends GuiceServletContextListener {

    private MyApplicationModule applicationModule;
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        super.contextInitialized(servletContextEvent);
        applicationModule.getWebApplicationModule()
            .postInitialize(servletContextEvent.getServletContext().getContextPath());
    }

    @Override
    protected Injector getInjector() {
        applicationModule = new MyApplicationModule();
        return Guice.createInjector(applicationModule);
    }
}
