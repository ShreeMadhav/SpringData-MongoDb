package com.empl.repositary;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.empl.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    
	Employee findByEmployeeId(String employeeId);

}
