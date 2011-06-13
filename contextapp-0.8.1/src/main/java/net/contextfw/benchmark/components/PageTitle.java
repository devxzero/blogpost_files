package net.contextfw.benchmark.components;

import net.contextfw.web.application.component.Attribute;
import net.contextfw.web.application.component.Buildable;
import net.contextfw.web.application.lifecycle.PageScoped;

@PageScoped
@Buildable
public class PageTitle {
	
	@Attribute
	public String title;
}
