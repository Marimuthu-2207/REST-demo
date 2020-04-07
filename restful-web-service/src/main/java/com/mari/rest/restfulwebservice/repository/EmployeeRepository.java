package com.mari.rest.restfulwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mari.rest.restfulwebservice.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends 
				JpaRepository<EmployeeModel, Long> {

}
