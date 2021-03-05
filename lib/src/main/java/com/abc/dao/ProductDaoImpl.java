package com.abc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.abc.entity.Product;
import com.abc.util.JpaUtil;

public class ProductDaoImpl implements ProductDao {

	private EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
	
	public Product findProductById(int productId) {		
	
		EntityManager entityManager = factory.createEntityManager();
		
		Product product = entityManager.find(Product.class, productId);
					
		entityManager.close();		
		
		return product;
	}

	@Override
	public void saveProduct(Product product) {
		
		EntityManager entityManager = factory.createEntityManager();
		
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		entityManager.persist(product);		
		txn.commit();		
		
		entityManager.close();			
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		product.setProductId(110); //assuming this product is existing in the db
        product.setName("Mobile");
        product.setPrice(50000);
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(product);
        System.out.println("Product updated");
        txn.commit();        

        entityManager.close();
        factory.close();   
		
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
        EntityManager entityManager = factory.createEntityManager();        
		 Product product = entityManager.find(Product.class, id);

	        EntityTransaction txn = entityManager.getTransaction();
	        txn.begin();
	        entityManager.remove(product);
	        System.out.println("Product deleted");
	        txn.commit();            
	        entityManager.close();
	        factory.close();        
	 
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
