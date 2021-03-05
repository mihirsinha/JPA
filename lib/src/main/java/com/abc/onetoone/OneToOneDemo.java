package com.abc.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToOneDemo {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
		EntityManager entityManager = factory.createEntityManager();
		
		Student student = new Student();
		student.setStudentId(40000);
		student.setStudentName("Sachin");
		
		Address address = new Address();
		address.setAddressId(40);
		address.setStreet("GT Road");
		address.setCity("Hyd");
		address.setPincode("3214523");
		address.setStudent(student);
		
		student.setAddr(address);
		
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		
		
		entityManager.persist(student);		
		
		txn.commit();		
		System.out.println("Student saved");		
		
		entityManager.close();		
		factory.close();		

	}

}
