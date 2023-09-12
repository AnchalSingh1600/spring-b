package net.javaguides.springb.service;

import org.springframework.stereotype.Service;

import net.javaguides.springb.model.Employee;

@Service
public interface EmployeeService {
 public Employee create(Employee employee);
}
