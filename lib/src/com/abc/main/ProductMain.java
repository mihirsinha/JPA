package com.abc.main;

 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

 

import com.abc.entity.Product;

 

public class ProductMain {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
        EntityManager entityManager = factory.createEntityManager();
        
        
//        //saving product
//        Product product = new Product();
//        product.setProductId(110);
//        product.setName("Mobile");
//        product.setPrice(40000);
//        
//        EntityTransaction txn = entityManager.getTransaction();
//        txn.begin();
//        entityManager.persist(product);
//        System.out.println("Product saved");
//        txn.commit();
        
        Product product = entityManager.find(Product.class, 106);
        
        if(product != null) {
            System.out.println(product.getName()+" "+product.getPrice());
        }
                
        entityManager.close();
        factory.close();        
    }
}