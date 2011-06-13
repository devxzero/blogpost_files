package net.contextfw.benchmark.views;

import net.contextfw.web.application.component.Component;
import net.contextfw.web.application.lifecycle.PageScoped;
import net.contextfw.web.application.lifecycle.View;

@View(url="/", parent=RootView.class)
@PageScoped
public class FrontView extends Component {
}