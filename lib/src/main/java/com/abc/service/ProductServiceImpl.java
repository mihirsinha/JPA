package com.abc.service;

import java.util.List;

import com.abc.dao.ProductDao;
import com.abc.dao.ProductDaoImpl;
import com.abc.entity.Product;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao = new ProductDaoImpl();
	
	@Override
	public Product getProductById(int productId) {
			
		Product product = productDao.findProductById(productId);
		return product;
	}

	@Override
	public void saveProduct(Product product) {
		
		productDao.saveProduct(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		
		
		
	}

	@Override
	public void deleteProduct(int productId) {
	
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return null;
	}


}
