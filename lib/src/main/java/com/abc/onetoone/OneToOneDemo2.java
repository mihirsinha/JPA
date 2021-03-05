package com.abc.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOneDemo2 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
		EntityManager entityManager = factory.createEntityManager();
		
		Student student = entityManager.find(Student.class, 40000);
		if(student!=null) {
			System.out.println(student.getStudentName());
			Address address = student.getAddr();
			System.out.println(address.getCity()+" "+address.getStreet()+" "+address.getPincode());
		}
		else {
			System.out.println("not found with id ");
		}	
		
		entityManager.close();
		factory.close();		

	}

}
