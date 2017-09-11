package org.javatest.springbootjsf.service;

import org.javatest.springbootjsf.model.Employee;
import org.javatest.springbootjsf.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/service")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @RequestMapping(value = "/employee/{id}", method = GET)
    public Employee getEmployeeById(@PathVariable Long id) {
        return this.employeeRepository.findOne(id);
    }
}
