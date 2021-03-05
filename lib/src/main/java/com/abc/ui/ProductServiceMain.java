package com.abc.ui;

import com.abc.entity.Product;
import com.abc.service.ProductService;
import com.abc.service.ProductServiceImpl;

public class ProductServiceMain {

	public static void main(String[] args) {
		
		ProductService productService = new ProductServiceImpl();
		
		int productId = 101;
		
		Product product = productService.getProductById(productId);
		if(product != null) {
			System.out.println(product.getName()+ "  "+product.getPrice());
		}
		else {
			System.out.println("Product not found with id: "+productId);
		}
		
		// save product		
		Product product1 = new Product();
		product1.setProductId(104);
		product1.setName("Laptiop");
		product1.setPrice(80000);
		
		productService.saveProduct(product1);
		
		System.out.println("Product saved");
		
	}

}
