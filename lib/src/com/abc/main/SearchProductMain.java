package com.abc.main;

import java.util.Scanner;

import com.abc.bean.Product;
import com.abc.service.ProductService;

public class SearchProductMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product id:");
		int pid = sc.nextInt();
		
		ProductService service = new ProductService();
		Product product = service.getProductById(pid);
		
		if(product != null) {
			int productId = product.getProductId();
			String name = product.getName();
			double price = product.getPrice();
			
			System.out.println(productId+" "+name+" "+price);
		}
		else {
			System.out.println("Product not available");
		}
		sc.close();
	}

}
