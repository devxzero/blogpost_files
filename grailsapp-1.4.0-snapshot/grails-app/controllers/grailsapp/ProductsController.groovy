package grailsapp

import s.*



class ProductsController {

	static scope = 'singleton'
	
	
    public def index() {
		[products: s.Service.getProducts(params.n.toInteger())]
	}
	
	public def env() {
		render grails.util.GrailsUtil.getEnvironment()
	}
}
