package com.abc.main;

import java.util.List;

import com.abc.bean.Product;
import com.abc.service.ProductService;

public class DisplayAllProductMain {

	public static void main(String[] args) {
		
		ProductService service = new ProductService();
		
		List<Product> products = service.getAllProducts();
		
		products.stream().forEach(p-> System.out.println(p.getProductId()+" "+p.getName()));		

	}

}
