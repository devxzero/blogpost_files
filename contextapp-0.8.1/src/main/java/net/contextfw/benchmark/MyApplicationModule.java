package net.contextfw.benchmark;

import net.contextfw.web.application.WebApplicationModule;
import net.contextfw.web.application.lifecycle.DefaultPageFlowFilter;
import net.contextfw.web.application.lifecycle.PageFlowFilter;
import net.contextfw.web.application.properties.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mycila.inject.jsr250.Jsr250;

public class MyApplicationModule extends AbstractModule {

    public MyApplicationModule() {}

    private WebApplicationModule webApplicationModule;
    
    @Override
    protected void configure() {

        Properties props = Properties.getDefaults()
          .add(Properties.RESOURCE_PATH, "net.contextfw.benchmark")
          .add(Properties.VIEW_COMPONENT_ROOT_PACKAGE, "net.contextfw.benchmark.views")
          .set(Properties.DEVELOPMENT_MODE, false)
          .set(Properties.XML_PARAM_NAME, "xml")
          .set(Properties.LIFECYCLE_LISTENER, MyLifecycleListener.class)
          .set(Properties.LOG_XML, false);
       
        webApplicationModule = new WebApplicationModule(props);
        
        install(getWebApplicationModule());
        install(Jsr250.newJsr250Module());
    }
    
    @Provides
    @Singleton
    public PageFlowFilter providePageFlowFilter() {
        return new DefaultPageFlowFilter();
    }

    public WebApplicationModule getWebApplicationModule() {
        return webApplicationModule;
    }
}