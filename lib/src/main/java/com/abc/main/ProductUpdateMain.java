package com.abc.main;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
 
import com.abc.entity.Product;
 
public class ProductUpdateMain {
	public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
        EntityManager entityManager = factory.createEntityManager();        
 
        Product product = new Product();
        product.setProductId(110); //assuming this product is existing in the db
        product.setName("Mobile");
        product.setPrice(50000);

        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(product);
        System.out.println("Product updated");
        txn.commit();        

        entityManager.close();
        factory.close();        
 
    }
}