package com.rit.group2.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rit.group2.models.Department;
import com.rit.group2.models.Employee;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
	
	@Query("select d from Department d where d.id = :id")
	Department findById(@Param("id") int id);
	
	@Query("select e from Employee e where e.department.id = :id")
	Set<Employee> findWorkersByDepartmentId(@Param("id") int id);

}
