package wicketapp;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

@SuppressWarnings("serial")
public abstract class TemplatePage extends WebPage {
	
    public TemplatePage(final PageParameters parameters) {
        super(parameters);
        // h2 page name
    	add(new Label("pageName", getPageName()));
    }
    
    public abstract String getPageName();
}
