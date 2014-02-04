package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import s.*;

import com.greenlaw110.rythm.play.UseRythmTemplateEngine;

@UseRythmTemplateEngine
public class Products extends Controller {
   public static void index(int n) {
		List<Product> products = Service.getProducts(n);
        render(products);	
    }
	
	public static void env() {
		renderText(play.Play.configuration.get("application.mode"));
	}
}