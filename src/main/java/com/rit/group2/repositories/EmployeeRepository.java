package com.rit.group2.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rit.group2.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("select e from Employee e where e.id = :id")
	Employee findById(@Param("id") int id);

	@Query("select e from Employee e where e.firstName = :fname AND e.lastName = :lname")
	Employee findByFirstAndLastName(@Param("fname") String firstName, @Param("lname") String lastName);

	@Query("select e from Employee e where e.email = :email")
	Employee findByEmail(@Param("email") String email);
}
