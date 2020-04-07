package com.mari.rest.restfulwebservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mari.rest.restfulwebservice.exceptions.RecordNotFoundException;
import com.mari.rest.restfulwebservice.model.EmployeeModel;
import com.mari.rest.restfulwebservice.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService service;
	
	
	@GetMapping
    public ResponseEntity<List<EmployeeModel>> getAllEmployees() {
        List<EmployeeModel> list = service.getAllEmployees();
 
        return new ResponseEntity<List<EmployeeModel>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	   @GetMapping("/{id}")
	    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
		   EmployeeModel entity = service.getEmployeeById(id);
	 
	        return new ResponseEntity<EmployeeModel>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	   
	   @PostMapping
	    public ResponseEntity<EmployeeModel> createOrUpdateEmployee(EmployeeModel employee)
	                                                    throws RecordNotFoundException {
		   EmployeeModel updated = service.createOrUpdateEmployee(employee);
	        return new ResponseEntity<EmployeeModel>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	   
	   @DeleteMapping("/{id}")
	    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
	        service.deleteEmployeeById(id);
	        return HttpStatus.FORBIDDEN;
	    }

}
