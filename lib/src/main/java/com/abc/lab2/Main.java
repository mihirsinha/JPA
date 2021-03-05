package com.abc.lab2;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
	EntityManager entityManager = factory.createEntityManager();
	
	Author a = entityManager.find(Author.class, 102);
	if(a!=null) {
		System.out.println(a.getName());
		Set<Book> b = a.getBook();
		//System.out.println(a.getName());
		for(Book s:b)
		{
			//System.out.print(s.getTitle()+" "+s.getISBN()+" "+s.getPrice()+" ");
		}
	}
	else {
		System.out.println("not found with id ");
	}	
	
	entityManager.close();
	factory.close();		
}
}