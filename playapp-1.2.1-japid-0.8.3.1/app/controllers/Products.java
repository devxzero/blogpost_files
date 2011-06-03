package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import cn.bran.play.JapidController;

import models.*;
import s.*;

public class Products extends JapidController {
	public static void index(int n) {
		List<Product> products = Service.getProducts(n);
		render(products);
	}

	public static void indexj(int n) {
		List<Product> products = Service.getProducts(n);
		renderJapid(products);
	}
	public static void env() {
		renderText(play.Play.configuration.get("application.mode"));
	}
}