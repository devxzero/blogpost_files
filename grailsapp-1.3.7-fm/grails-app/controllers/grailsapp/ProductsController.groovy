package grailsapp

import s.*



class ProductsController {
    def index = {
		[products: s.Service.getProducts(params.n.toInteger())]
	}
	
	def env = {
		render grails.util.GrailsUtil.getEnvironment()
	}
}
