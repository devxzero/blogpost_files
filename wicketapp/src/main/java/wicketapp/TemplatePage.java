package wicketapp;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class TemplatePage extends WebPage {
	
	private Model pageNameModel = new Model();
	
    public TemplatePage(final PageParameters parameters) {
    	// h2 page name
    	add(new Label("pageName", pageNameModel));
    }
    
    public void setPageName(String name) {
    	pageNameModel.setObject(name);
    }
    
}
