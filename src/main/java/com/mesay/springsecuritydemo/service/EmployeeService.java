package com.mesay.springsecuritydemo.service;

import com.mesay.springsecuritydemo.model.Employee;
import com.mesay.springsecuritydemo.web.dto.EmployeeDto;

import java.util.List;
public interface EmployeeService {
  List<Employee> getAllEmployees();
  Employee addEmployee(Employee employee);
  Employee findById(Long employeeId);
  Employee updateEmployee(Employee employee);
  void deleteEmployee(Long employeeId);
  Employee searchEmployee(String EmployeeName);
}
