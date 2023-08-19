package com.mesay.springsecuritydemo.service;
import com.mesay.springsecuritydemo.model.Employee;
import com.mesay.springsecuritydemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee employeeToBeSaved = new Employee(employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPosition());
        employeeRepository.save(employeeToBeSaved);
        return employeeToBeSaved;
    }

    @Override
    public Employee findById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return employee;

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee employeeToBeUpdated = employeeRepository.findById(employee.getId()).get();
        employeeToBeUpdated.setFirstName(employee.getFirstName());
        employeeToBeUpdated.setLastName(employee.getLastName());
        employeeToBeUpdated.setEmail(employee.getEmail());
        employeeToBeUpdated.setPosition(employeeToBeUpdated.getPosition());
        return employeeRepository.save(employeeToBeUpdated);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employeeIfExist = employeeRepository.findById(employeeId).get();
        employeeRepository.delete(employeeIfExist);
    }

    @Override
    public Employee searchEmployee(String textToBeSearched) {
        int i;
        List<Employee> employees = employeeRepository.findAll();
        for (i = 0; i<employees.size(); i++){
            if (employees.get(i).getFirstName().contains(textToBeSearched)){
                return null;
            }
        }
        return employees.get(i);
    }
}
