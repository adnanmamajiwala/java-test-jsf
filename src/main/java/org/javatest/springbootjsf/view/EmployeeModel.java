package org.javatest.springbootjsf.view;

import lombok.Data;
import org.javatest.springbootjsf.model.Employee;
import org.javatest.springbootjsf.repositories.EmployeeRepository;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import static javax.faces.context.FacesContext.getCurrentInstance;

@ManagedBean(name = "empModel", eager = true)
@RequestScoped
@Data
public class EmployeeModel {

    @ManagedProperty(value = "#{employeeRepository}")
    private EmployeeRepository employeeRepository;

    @ManagedProperty(value = "#{employee}")
    private Employee employee;


    public String saveEmployee() {
        employeeRepository.save(employee);

        getCurrentInstance().addMessage("errors",
                new FacesMessage(SEVERITY_INFO, "Employee created",
                        "The employee " + employee.getName() + " has been created with id=" + employee.getId()));

        return resetEmployee();
    }

    private String resetEmployee() {
        employee.setId(null);
        employee.setName("");
        employee.setAddress("");
        employee.setDepartmentId(null);

        return "index.xhtml";
    }

    public String deleteEmployee() {
        employeeRepository.delete(employee.getId());
        return resetEmployee();
    }

    public void doFindEmployeeById() {
        Employee found = employeeRepository.findOne(this.employee.getId());

        employee.setId(found.getId());
        employee.setName(found.getName());
        employee.setAddress(found.getAddress());
    }

    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

}
