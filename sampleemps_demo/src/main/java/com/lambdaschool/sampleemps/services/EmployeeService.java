package com.lambdaschool.sampleemps.services;

import com.lambdaschool.sampleemps.models.Employee;
import com.lambdaschool.sampleemps.views.EmpNameCountJobs;

import java.util.List;



public interface EmployeeService
{
    List<Employee> findAllEmployees();
    List<Employee> findEmployeeNameContaining(String subname);
    List<Employee> findEmployeeEmailContaining(String subemail);
    List<EmpNameCountJobs> getEmpNameCountJobs();
    Employee save(Employee employee);

}
