package com.mari.rest.restfulwebservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mari.rest.restfulwebservice.exceptions.RecordNotFoundException;
import com.mari.rest.restfulwebservice.model.EmployeeModel;
import com.mari.rest.restfulwebservice.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	 public List<EmployeeModel> getAllEmployees()
	    {
	        List<EmployeeModel> employeeList = employeeRepository.findAll();
	         
	        if(employeeList.size() > 0) {
	            return employeeList;
	        } else {
	            return new ArrayList<EmployeeModel>();
	        }
	    }
	 
	 public EmployeeModel getEmployeeById(Long id) throws RecordNotFoundException
	    {
	        Optional<EmployeeModel> employee = employeeRepository.findById(id);
	         
	        if(employee.isPresent()) {
	            return employee.get();
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    }
	 
	 public EmployeeModel createOrUpdateEmployee(EmployeeModel model) throws RecordNotFoundException{
		 Optional<EmployeeModel> employee = employeeRepository.findById(model.getId());
		 
		 if(employee.isPresent())
	        {
			 EmployeeModel newModel = employee.get();
			 newModel.setEmail(model.getEmail());
			 newModel.setFirst_name(model.getFirst_name());
			 newModel.setLast_name(model.getLast_name());
	 
			 newModel = employeeRepository.save(newModel);
	             
	            return newModel;
	        } else {
	        	model = employeeRepository.save(model);
	             
	            return model;
	        } 
	 }
	 
	 
	 public void deleteEmployeeById(Long id) throws RecordNotFoundException
	    {
	        Optional<EmployeeModel> employee = employeeRepository.findById(id);
	         
	        if(employee.isPresent())
	        {
	        	employeeRepository.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    }
	 
	 
}
