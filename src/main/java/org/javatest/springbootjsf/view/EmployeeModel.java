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

@ManagedBean(name = "model", eager = true)
@RequestScoped
@Data
public class EmployeeModel {

    @ManagedProperty(value = "#{employeeRepository}")
    private EmployeeRepository employeeRepository;

    @ManagedProperty(value = "#{employee}")
    private Employee employee;

    public String doCreateEmployee() {
        employeeRepository.save(employee);

        getCurrentInstance().addMessage("errors",
                new FacesMessage(SEVERITY_INFO, "Employee created",
                        "The employee " + employee.getTitle() + " has been created with id=" + employee.getId()));

        employee.setTitle("");
        employee.setPrice(null);
        employee.setDescription("");
        employee.setIllustrations(false);
        employee.setNbofpage(null);

        return "index.xhtml";
    }

    public void doFindEmployeeById() {
        Employee found = employeeRepository.findOne(this.employee.getId());

        employee.setId(found.getId());
        employee.setTitle(found.getTitle());
        employee.setPrice(found.getPrice());
        employee.setNbofpage(found.getNbofpage());
        employee.setDescription(found.getDescription());
    }

    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

}
