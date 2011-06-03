package japidviews._layouts;

import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
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
// NOTE: This file was generated from: japidviews/_layouts/main.html
// Change to this file will be lost next time the template file is compiled.
//

public abstract class main extends cn.bran.japid.template.JapidTemplateBase {
	public static final String sourceTemplate = "japidviews/_layouts/main.html";
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

	public main() {
		super(null);
	}

	public main(StringBuilder out) {
		super(out);
	}

	@Override
	public void layout() {
		p("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n"
				+
				"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
				+
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">\n"
				+
				"    <head>\n"
				+
				"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n"
				+
				"        \n" +
				"        <title>");// line 1
		title();// line 7
		p("</title>\n" +
				"\n" +
				"        <link rel=\"stylesheet\" media=\"screen\" href=\"");// line 7
		p(lookupStatic("/public/default.css"));// line 9
		p("\">\n" +
				"        ");// line 9
		moreStyles();// line 10
		p("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"");// line 10
		p(lookupStatic("/public/images/favicon.png"));// line 11
		p("\">\n" +
				"        ");// line 11
		moreScripts();// line 12
		p("    </head>\n"
				+
				"    \n"
				+
				"    <body>\n"
				+
				"        <div id=\"maincontainer\">\n"
				+
				"            <div id=\"topsection\">\n"
				+
				"                <div class=\"innertube\"><h1>Company Title .....</h1></div>\n"
				+
				"            </div>\n" +
				"            <div id=\"contentwrapper\">\n" +
				"                <div id=\"contentcolumn\">\n" +
				"                    \n" +
				"                    <!-- Page name needs to be injected -->\n"
				+
				"                    <div><h2>");// line 12
		pagename();// line 24
		p("</h2></div>\n" +
				"                    <div class=\"innertube\"> \n" +
				"                        ");// line 24
		doLayout();// line 26
		p("                    </div>\n" +
				"                </div>\n" +
				"            </div>\n" +
				"\n" +
				"            <div id=\"leftcolumn\">\n" +
				"                <div class=\"innertube\">\n" +
				"                    <h3>Side bar.....</h3>\n" +
				"                </div>\n" +
				"            </div>\n" +
				"\n" +
				"            <div id=\"footer\">footer.....</div>\n" +
				"        </div>\n" +
				"    </body>\n" +
				"</html>\n");// line 26
	}

	protected void moreStyles() {
	};

	protected void title() {
	};

	protected void pagename() {
	};

	protected void moreScripts() {
	};

	protected abstract void doLayout();
}
