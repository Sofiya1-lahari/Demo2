package com.javademo.springboot.Service;

import java.util.List;
import java.util.Optional;

import com.javademo.springboot.Exception.UserNotFoundException;
import com.javademo.springboot.Model.Employee;
import com.javademo.springboot.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EmployeeServiceImplementation  implements EmployeeService{
    
    @Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	 
	@Override
	public Employee getEmployeeById(long id)throws UserNotFoundException {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (!optional.isPresent())
		 {
			throw new UserNotFoundException("Employee not found for the id :: "+id +"in the database");
			
		} 
			
		employee = optional.get();
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		Optional <Employee> emp=this.employeeRepository.findById(id);
      if(! emp.isPresent())
      {
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user Not found in user repo");
      }
		this.employeeRepository.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}
}
