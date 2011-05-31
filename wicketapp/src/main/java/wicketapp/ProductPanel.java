package wicketapp;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

@SuppressWarnings("serial")
public class ProductPanel extends Panel {

	public ProductPanel(String id, Product product) {
		super(id);
		
		Label nameLabel = new Label("productname", product.getName());
		add(nameLabel);
		
		Label priceLabel = new Label("price", Model.of(product.getPrice()));
		add(priceLabel);
	}

}
