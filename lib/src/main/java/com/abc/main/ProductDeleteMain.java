package com.abc.main;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
 
import com.abc.entity.Product;
 
public class ProductDeleteMain {
	public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
        EntityManager entityManager = factory.createEntityManager();        
 
        Product product = entityManager.find(Product.class, 110);

        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(product);
        System.out.println("Product deleted");
        txn.commit();            

        entityManager.close();
        factory.close();    
    } 
}