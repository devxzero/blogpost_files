package controllers

import play._
import play.mvc._
import s._
import views.Products._

object Products extends Controller {
    import views.Products._

	def index(n: Int) = html.index(Service.getProducts(n)) 
}
