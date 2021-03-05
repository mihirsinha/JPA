package com.abc.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToManyDemo {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
		EntityManager entityManager = factory.createEntityManager();
		

		Department department = new Department();
		department.setDeptNo(11);
		department.setName("IT");
		
		Employee1 emp1 = new Employee1();
		emp1.setEmpId(100);
		emp1.setName("Raj");
		emp1.setEmail("raj@tmail.com");		
		//emp1.setDept(department);
		department.addEmployee(emp1);
		
		Employee1 emp2 = new Employee1();
		emp2.setEmpId(200);
		emp2.setName("Sam");
		emp2.setEmail("sam@tmail.com");
		//emp2.setDept(department);
		department.addEmployee(emp2);
		
		Employee1 emp3 = new Employee1();
		emp3.setEmpId(300);
		emp3.setName("Tom");
		emp3.setEmail("tom@tmail.com");
		//emp3.setDept(department);
		department.addEmployee(emp3);		
		
		Set<Employee1> emps = new HashSet<>();
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
	
		department.setEmployees(emps);		
		
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		
		entityManager.persist(department);
		System.out.println("Departmetn saved along with employees");
		
		txn.commit();
		entityManager.close();		
		factory.close();		

	}

}