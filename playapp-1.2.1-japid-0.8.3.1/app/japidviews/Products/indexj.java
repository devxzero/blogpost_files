package japidviews.Products;

import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import s.*;
import static play.templates.JavaExtensions.*;
import static cn.bran.play.JapidPlayAdapter.*;
import static play.data.validation.Validation.*;
import japidviews._layouts.*;
import static japidviews._javatags.JapidWebUtil.*;
import play.data.validation.Validation;
import play.mvc.Scope.*;
import models.*;
import play.data.validation.Error;
import japidviews._tags.*;
import controllers.*;
import play.mvc.Http.*;
import japidviews._javatags.*;
//
// NOTE: This file was generated from: japidviews/Products/indexj.html
// Change to this file will be lost next time the template file is compiled.
//

public class indexj extends main {
	public static final String sourceTemplate = "japidviews/Products/indexj.html";
	{
		headers.put("Content-Type", "text/html; charset=utf-8");
	}

	// - add implicit fields with Play

	final Request request = Request.current();
	final Response response = Response.current();
	final Session session = Session.current();
	final RenderArgs renderArgs = RenderArgs.current();
	final Params params = Params.current();
	final Validation validation = Validation.current();
	final cn.bran.play.FieldErrors errors = new cn.bran.play.FieldErrors(
			validation);
	final play.Play _play = new play.Play();

	// - end of implicit fields with Play 

	// -- set up the tag objects
	final ProductDetail _ProductDetail2 = new ProductDetail(getOut());
	{
		_ProductDetail2.setActionRunners(getActionRunners());
	}

	// -- end of the tag objects

	public indexj() {
		super(null);
	}

	public indexj(StringBuilder out) {
		super(out);
	}

	private List<Product> products;

	public cn.bran.japid.template.RenderResult render(List<Product> products) {
		this.products = products;
		long t = -1;
		super.layout();
		return new cn.bran.japid.template.RenderResultPartial(this.headers,
				getOut(), t, actionRunners);
	}

	@Override
	protected void doLayout() {
		//------
		p("<table>");
		for (Product product : products) {
			p("<tr>\n" +
					"            <td>");
			_ProductDetail2.setOut(getOut());
			_ProductDetail2.render(product);

			p("</td>\n" +
					"            <td>");
			for (Category category : product.getCategories()) {
				p(category.getName());
				p(",");
			}
			p("</td>\n" +
					"        </tr>");
		}
		p("</table>");

	}

	@Override
	protected void title() {
		p("Product listing");
		;
	}

	@Override
	protected void pagename() {
		p("Product listing");
		;
	}
}
