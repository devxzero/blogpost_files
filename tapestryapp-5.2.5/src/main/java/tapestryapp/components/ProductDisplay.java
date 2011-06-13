package tapestryapp.components;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

import tapestryapp.Product;

public class ProductDisplay {
	
	@Parameter(required = true)
	@Property
	private Product product;

}
