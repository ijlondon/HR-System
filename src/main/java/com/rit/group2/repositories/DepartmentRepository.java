package com.rit.group2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rit.group2.models.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
