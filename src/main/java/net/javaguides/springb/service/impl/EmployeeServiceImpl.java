package net.javaguides.springb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springb.model.Employee;
import net.javaguides.springb.repository.EmployeeRepository;
import net.javaguides.springb.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee create(Employee employee) {
		
		return employeeRepository.save(employee);
	}

}
