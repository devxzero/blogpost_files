module ProductsHelper
	class Product
		attr :name, true
		attr :price, true
		attr :categories, true
		def initialize(name, price, description, categories)
			@name = name
			@price = price
			@description = description
			@categories = categories
		end		
	end
	
	class Category
		attr :name, true
		def initialize(name)
			@name = name
		end
	end
	
	class Service
		@@products = Array.new
		def Service.getProducts
			if @@products.size == 0
				categories = Array.new
				for i in (0 .. 5)
					categories.push(Category.new((1000 + i).to_s))
					
				end
			
				for i in (0 .. 1000)
					p = Product.new(i.to_s, i, (i*i).to_s, categories)
					@@products.push(p)
				end
			end
			
			@@products
		end
	end
end