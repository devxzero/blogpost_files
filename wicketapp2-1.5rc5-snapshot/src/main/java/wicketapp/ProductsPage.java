package wicketapp;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

@SuppressWarnings("serial")
public class ProductsPage extends TemplatePage {

	public ProductsPage(final PageParameters parameters) {
		super(parameters);
		
		int n = parameters.get("n").toInt();

		ListView<Product> productsLV = new ListView<Product>("products", Service.getProducts(n)) {
			@Override
			protected void populateItem(ListItem<Product> li) {
				Product product = li.getModelObject();
				ProductPanel productPanel = new ProductPanel("product", product);
				li.add(productPanel);
				
				RepeatingView categoriesView = new RepeatingView("categories");
				li.add(categoriesView);
				
				for (Category category : product.getCategories()) {
				    Label categoryLabel = new Label(categoriesView.newChildId(), category.getName() + ", ");
				    categoryLabel.setRenderBodyOnly(true);
				    categoriesView.add(categoryLabel);
				}
			}
		};
		add(productsLV);		
	}

    @Override
    public String getPageName() {
        return "Products listing";
    }
}