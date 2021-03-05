package com.abc.dao;

import java.util.List;

import com.abc.entity.Product;

public interface ProductDao {
	
	Product findProductById(int productId);
	
	void saveProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(int id);
	
	List<Product> getAllProducts();	

}
