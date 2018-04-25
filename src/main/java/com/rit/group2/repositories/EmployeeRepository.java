package com.rit.group2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rit.group2.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("select * from Employee e where e.id = :employeeId")
	Employee findById(@Param("lastname") int employeeId);

}
