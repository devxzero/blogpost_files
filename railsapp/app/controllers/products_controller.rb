require 'products_helper'

class ProductsController < ApplicationController
  skip_before_filter :verify_authenticity_token
  protect_from_forgery :except => :index
	
  def index
	@products = ProductsHelper::Service.getProducts
	
	
	
  end
end
