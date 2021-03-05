package com.abc.service;

import java.util.List;

import com.abc.entity.Product;

public interface ProductService {

	Product getProductById(int productId);
	
	void saveProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(int productId);
	
	List<Product> getAllProducts();
	
}
