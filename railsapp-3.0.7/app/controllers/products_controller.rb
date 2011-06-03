require 'products_helper'

class ProductsController < ApplicationController
  skip_before_filter :verify_authenticity_token
  protect_from_forgery :except => :index
	
  def index
	n = params[:n].to_i
	@products = ProductsHelper::Service.getProducts(n)
  end
  
  def env
	render(:text => RAILS_ENV)
  end
end
