package s

import scala.collection.mutable.Set
import scala.collection.mutable.ListBuffer

class Product {
	// Fields
	var name: String = _
	var price: Int = _
	var description: String = _
	var categories: Set[Category] = Set()
}

class Category(var name: String)

object Service {
	private val products: ListBuffer[Product] = ListBuffer()
	private val categories: ListBuffer[Category] = ListBuffer()
	
	println("Creating products")
		
	for (i <- 0 to 5) {
		val name = (1000 + i).toString
		categories += new Category(name)
	}
	println(categories)
	
	
	for (i <- 0 to 20000) {
		val p = new Product()
		p.name = i.toString
		p.description = (i * i).toString
		p.price = i
		
		categories.foreach{
			p.categories += _
		}
		
		products += p
	}
	
	def getProducts(max: Int) = products.slice(0, max)
}