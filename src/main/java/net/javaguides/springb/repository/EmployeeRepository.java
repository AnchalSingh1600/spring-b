package net.javaguides.springb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springb.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	
}
