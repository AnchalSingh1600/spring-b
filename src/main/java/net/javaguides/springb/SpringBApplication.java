package net.javaguides.springb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.springb.model.Employee;
import net.javaguides.springb.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBApplication.class, args);
	}

	
	@Autowired 
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Employee employee = new Employee();
//		employee.setFirstName("Ramesh");
//		employee.setLastname("Singh");
//		employee.setEmailId("ramesh123@gmail.com");
//		employeeRepository.save(employee);
//		
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Anchal");
//		employee1.setLastname("Singh");
//		employee1.setEmailId("anchal123@gmail.com");
//		employeeRepository.save(employee1);
//		
//		Employee employee2 = new Employee();
//		employee2.setFirstName("Shruti");
//		employee2.setLastname("Singh");
//		employee2.setEmailId("shruti123@gmail.com");
//		employeeRepository.save(employee2);
//		
	}

}
