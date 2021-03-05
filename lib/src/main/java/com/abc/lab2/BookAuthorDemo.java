package com.abc.lab2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class BookAuthorDemo {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
		EntityManager entityManager = factory.createEntityManager();
		
		Book book1=new Book();
		book1.setIsbn(111);
		book1.setPrice(1000);
		book1.setTitle("Book11");
		
		Book book2=new Book();
		book2.setIsbn(222);
		book2.setPrice(500);
		book2.setTitle("Book12");
		
		Author author1=new Author();
		author1.setId(2);
		author1.setName("My Name");
		
		author1.addBook(book1);
		author1.addBook(book2);
		
		/*Book book3=new Book();
		book1.setIsbn(101);
		book1.setPrice(1050);
		book1.setTitle("Book21");
		
		Book book4=new Book();
		book2.setIsbn(112);
		book2.setPrice(770);
		book2.setTitle("Book22");
		
		Author author2=new Author();
		author1.setId(2);
		author1.setName("MS");
		
		author2.addBook(book3);
		author2.addBook(book4);*/
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		
		entityManager.persist(author1);
		//entityManager.persist(author2);
		
		System.out.println("Inserted");

		txn.commit();
		//txn.begin();
		entityManager.close();
		/*EntityManager entityManager1 = factory.createEntityManager();
		entityManager1.persist(author2);
		//entityManager.persist(author2);
		
		System.out.println("Inserted");

		txn.commit();
		entityManager1.close();	*/	
		factory.close();
	}
}
