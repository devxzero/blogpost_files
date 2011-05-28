package code
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
//import scala.collection.JavaConversions._
import Helpers._
import _root_.s._


class ProductsSnippet {
  
  def showProducts = {
	val products = Service.products
	"tr" #> (in => products.flatMap{ p =>
		(".productname *" #> <div class="product"><img src={p.name + ".jpg"} /><span class="productname">{p.name}</span>, <span class="price">${p.price}</span></div> &
		".categories *" #> p.categories.map(_.name).mkString(", "))(in)
	})
  
  }
}
