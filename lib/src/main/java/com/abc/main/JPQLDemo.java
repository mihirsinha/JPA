package com.abc.main;
 
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
 
import com.abc.entity.Product;
 
public class JPQLDemo { 
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
        EntityManager entityManager = factory.createEntityManager();    

        String jpql = "select p from Product p";

        //Query query = entityManager.createQuery(jpql);        
        //List<Product> list = query.getResultList();

        //select all products
        TypedQuery<Product> query = entityManager.createQuery(jpql,Product.class);
        List<Product> list = query.getResultList();            
        list.stream().forEach(p-> System.out.println(p.getProductId()+" "+p.getName()+"  "+p.getPrice()));
        System.out.println("*******************************************");

        //select product by name (using positional parameters)
        TypedQuery<Product> query2 = entityManager.createQuery("Select p from Product p where p.name = ?1",Product.class);
        query2.setParameter(1, "PC");        
        Product product = query2.getSingleResult();        
        System.out.println("product details");
        System.out.println(product.getProductId()+" "+product.getName()+"  "+product.getPrice());
        System.out.println("*******************************************");

        //select Price of a praticular product (using positional parameters)
        TypedQuery<Double> query3 = entityManager.createQuery("Select p.price from Product p where p.name = ?1",Double.class);
        query3.setParameter(1, "PC");        
        double price= query3.getSingleResult();        
        System.out.println("price : "+price);    
        System.out.println("*******************************************");

        //select product by name (using named parameters)
        TypedQuery<Product> query4 = entityManager.createQuery("Select p from Product p where p.name = :pname",Product.class);
        query4.setParameter("pname", "PC");

        System.out.println("*******************************************");
        //named query
        TypedQuery<Product> query5 = entityManager.createNamedQuery("getAllProducts", Product.class);
        List<Product> products = query5.getResultList();
        products.stream().forEach(p-> System.out.println(p.getProductId()+" "+p.getName()+"  "+p.getPrice()));    

        System.out.println("*******************************************");
        //named query
        TypedQuery<Double> query6 = entityManager.createNamedQuery("getSumOfPrices", Double.class);
        double sum = query6.getSingleResult();
        System.out.println("sum: "+sum);

        entityManager.close();        
        factory.close();        
 
    } 
}