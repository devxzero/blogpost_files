package tapestryapp.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;

public class AppModule
{
    public static void bind(ServiceBinder binder)
    {
    	binder.bind(DataService.class, DataService.class);
    }
    
    
    public static void contributeApplicationDefaults(
            MappedConfiguration<String, String> configuration)
    {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
        configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT");
        configuration.add(SymbolConstants.DEFAULT_STYLESHEET, "context:default.css" );
        configuration.add(SymbolConstants.DEFAULT_JAVASCRIPT, "" );
        configuration.add(SymbolConstants.BLACKBIRD_ENABLED, "false");
        configuration.add(SymbolConstants.COMBINE_SCRIPTS, "false" );
        configuration.add(SymbolConstants.GZIP_COMPRESSION_ENABLED, "false");
    }
    
    public static void contributeIgnoredPathsFilter(Configuration<String> configuration)
    {
      configuration.add("/.*\\.jpg");
    }
}
