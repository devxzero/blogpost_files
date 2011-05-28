package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import s.*;

public class Products extends Controller {
   public static void index() {
		List<Product> products = Service.getProducts();
        render(products);	
    }
	
	public static void env() {
		renderText(play.Play.configuration.get("application.mode"));
	}
}