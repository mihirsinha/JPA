package com.abc.service;

import java.util.List;

import com.abc.bean.Product;
import com.abc.dao.ProductDAO;

public class ProductService {
	
	
	public boolean addProduct(Product product) {
		
		//validate input 		
		ProductDAO productDAO = new ProductDAO();
		
		boolean result = productDAO.insert(product);
		
		return result;
	}
	
	public Product getProductById(int productId) {
		
		ProductDAO productDAO = new ProductDAO();
		
		Product product = productDAO.fetchProductById(productId);
				
		return product;
	}
	
	public List<Product> getAllProducts() {
		
		ProductDAO productDAO = new ProductDAO();
		
		List<Product> products = productDAO.fetchAllProducts();
		
		return products;	
		
	}

}
