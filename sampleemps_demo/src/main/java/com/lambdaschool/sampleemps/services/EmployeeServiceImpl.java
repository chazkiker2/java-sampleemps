package com.lambdaschool.sampleemps.services;


import com.lambdaschool.sampleemps.models.Employee;
import com.lambdaschool.sampleemps.repositories.EmployeeRepository;
import com.lambdaschool.sampleemps.views.EmpNameCountJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



@Transactional
@Service(value = "employeeService") // needed to name this implementation as the service to use
public class EmployeeServiceImpl
		implements EmployeeService {
	private EmployeeRepository employeeRepo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> list = new ArrayList<>();
		/*
		 * findAll returns an iterator set.
		 * iterate over the iterator set, add each el to the arraylist above
		 * */
		employeeRepo.findAll()
		            .iterator()
		            .forEachRemaining(list::add);
		return list;
	}

	@Override
	public List<Employee> findEmployeeNameContaining(String subname) {
		return employeeRepo.findByNameContainingIgnoreCase(subname);
	}

	@Override
	public List<Employee> findEmployeeEmailContaining(String subemail) {
		return employeeRepo.findByEmails_EmailContainingIgnoreCase(subemail);
	}

	@Override
	public List<EmpNameCountJobs> getEmpNameCountJobs() {
		return employeeRepo.getCountEmpJobs();
	}

	@Transactional
	@Override
	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}


}
