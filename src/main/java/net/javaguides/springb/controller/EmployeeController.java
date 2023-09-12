package net.javaguides.springb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springb.exception.ResourceNotFoundException;
import net.javaguides.springb.model.Employee;
import net.javaguides.springb.repository.EmployeeRepository;
import net.javaguides.springb.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	
	@Autowired 
	private EmployeeRepository employeeRepository;
	EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	//Build create employee Rest Api
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	
	//build get employee by id Rest Api
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: "+id));
		
		return ResponseEntity.ok(employee);
	}
	
	//build update employee rest api
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
		Employee updateEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: "+id));
		
		updateEmployee.setFirstName(employeeDetails.getFirstName());
		updateEmployee.setLastname(employeeDetails.getLastName());	
		updateEmployee.setEmailId(employeeDetails.getEmailId());
		
		employeeRepository.save(updateEmployee);
		
		return ResponseEntity.ok(updateEmployee);
		
		
	}
	
	//build delete employee rest api
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: "+id));
		
		employeeRepository.delete(employee);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("{id}")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.create(employee);
		
	}
	
}
