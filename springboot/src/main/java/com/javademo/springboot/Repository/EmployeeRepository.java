package com.javademo.springboot.Repository;



import com.javademo.springboot.Model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long>{
    
}