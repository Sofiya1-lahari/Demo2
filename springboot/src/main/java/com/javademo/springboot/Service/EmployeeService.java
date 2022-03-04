package com.javademo.springboot.Service;

import java.util.List;

import com.javademo.springboot.Exception.UserNotFoundException;
import com.javademo.springboot.Model.Employee;

import org.springframework.data.domain.Page;



public interface EmployeeService {
    
    List<com.javademo.springboot.Model.Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id) throws UserNotFoundException, com.javademo.springboot.Exception.UserNotFoundException;
	void deleteEmployeeById(long id);

	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}