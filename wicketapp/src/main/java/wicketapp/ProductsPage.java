package wicketapp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ProductsPage extends TemplatePage {

	public ProductsPage(final PageParameters parameters) {
		super(parameters);
		
		setPageName("Products listing");
		
		
		ListView<Product> productsLV = new ListView<Product>("products", Service.getProducts()) {
			@Override
			protected void populateItem(ListItem<Product> li) {
				Product product = li.getModelObject();
				ProductPanel productPanel = new ProductPanel("product", product);
				li.add(productPanel);
				
//				StringBuilder sb = new StringBuilder();
//				for (Category c : product.getCategories()) {
//					sb.append(c.getName() + ", ");
//				}
//				li.add(new Label("categories", sb.toString()));
				
				//List<Category> l = (List<Category>) Arrays.asList(product.getCategories());
				List<Category> categories = new ArrayList<Category>(product.getCategories());
				
				ListView<Category> categoriesLV = new ListView<Category>("categories", categories) {
					@Override
					protected void populateItem(ListItem<Category> catLi) {
						//catLi.setRenderBodyOnly(true);
						Category category = catLi.getModelObject();
						catLi.add(new Label("category", category.getName()).setRenderBodyOnly(true));
					}
				};
				//categoriesLV.setRenderBodyOnly(true);
				li.add(categoriesLV);
				
				
			}
		};
		add(productsLV);		
	}
}