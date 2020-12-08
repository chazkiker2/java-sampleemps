package com.lambdaschool.sampleemps.controllers;


import com.lambdaschool.sampleemps.models.Employee;
import com.lambdaschool.sampleemps.services.EmployeeService;
import com.lambdaschool.sampleemps.views.EmpNameCountJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/employees") // optional
public class EmployeeController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(value = "/employees")
	public ResponseEntity<?> listAllEmployees() {
		List<Employee> empList = employeeService.findAllEmployees();
		return new ResponseEntity<>(
				empList,
				HttpStatus.OK
		);
	}

	@GetMapping(value = "/employeename/{subname}")
	public ResponseEntity<?> listEmployeesWithName(
			@PathVariable
					String subname
	) {
		List<Employee> empList = employeeService.findEmployeeNameContaining(subname);
		return new ResponseEntity<>(
				empList,
				HttpStatus.OK
		);
	}

	@GetMapping(value = "/employeeemail/{subemail}")
	public ResponseEntity<?> listEmployeesWithEmail(
			@PathVariable
					String subemail
	) {
		List<Employee> empList = employeeService.findEmployeeEmailContaining(subemail);
		return new ResponseEntity<>(
				empList,
				HttpStatus.OK
		);
	}

	@GetMapping(value="/job/counts")
	public ResponseEntity<?> getEmpJobCounts() {
		List<EmpNameCountJobs> empList = employeeService.getEmpNameCountJobs();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

}
