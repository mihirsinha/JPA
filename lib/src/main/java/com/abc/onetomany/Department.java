package com.abc.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department_tbl")
public class Department {

	@Id
	@Column(name = "dept_id")
	private int deptNo;

	@Column(name = "dept_name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dept")
	private Set<Employee1> employees = new HashSet<Employee1>();

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee1> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee1> employees) {
		this.employees = employees;
	}

	// the method below will add employee to department
	// also serves the purpose to avoid cyclic references.
	public void addEmployee(Employee1 employee) {
		employee.setDept(this); // this will avoid nested cascade
		this.getEmployees().add(employee);
	}

}