package com.abc.main;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import com.abc.entity.Product;
 
public class ProductFindMain { 
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
        EntityManager entityManager = factory.createEntityManager();

        Product product = entityManager.find(Product.class, 111);

        if(product != null) {
        	System.out.println(product.getName()+" "+product.getPrice());
        }
        else {
        	System.out.println("Product Not found");
        }
        entityManager.close();
        factory.close();        
 
    } 
}