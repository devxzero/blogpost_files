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
		def Service.getProducts(n)		
			if @@products.size == 0
				puts "Generating products"
				categories = Array.new
				for i in (0 .. 5)
					categories.push(Category.new((1000 + i).to_s))
					
				end
			
				for i in (0 .. 20000)
					p = Product.new(i.to_s, i, (i*i).to_s, categories)
					@@products.push(p)
				end
			end
			
			@@products[0, n]
		end
	end
end