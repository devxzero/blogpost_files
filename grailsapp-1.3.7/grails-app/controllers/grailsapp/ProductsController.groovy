package grailsapp

import s.*



class ProductsController {
    def index = {
		[products: s.Service.getProducts()]
	}
	
	def env = {
		render grails.util.GrailsUtil.getEnvironment()
	}
}
