package japidviews._tags;

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
// NOTE: This file was generated from: japidviews/_tags/ProductDetail.html
// Change to this file will be lost next time the template file is compiled.
//

public class ProductDetail extends cn.bran.japid.template.JapidTemplateBase {
	public static final String sourceTemplate = "japidviews/_tags/ProductDetail.html";
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

	public ProductDetail() {
		super(null);
	}

	public ProductDetail(StringBuilder out) {
		super(out);
	}

	private Product product;

	public cn.bran.japid.template.RenderResult render(Product product) {
		this.product = product;
		long t = -1;
		super.layout();
		return new cn.bran.japid.template.RenderResultPartial(this.headers,
				getOut(), t, actionRunners);
	}

	@Override
	protected void doLayout() {
		//------
		p("<div class=\"product\">\n" +
				"	<img src=\"");// line 3
		p(product.getName());// line 5
		p(".jpg\" />\n" +
				"	<span class=\"productname\">");// line 5
		p(product.getName());// line 6
		p("</span>, <span class=\"price\">$");// line 6
		p(product.getPrice());// line 6
		p("</span>\n" +
				"</div>\n");// line 6

	}

}
