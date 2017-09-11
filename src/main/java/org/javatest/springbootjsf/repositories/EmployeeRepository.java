package org.javatest.springbootjsf.repositories;

import org.javatest.springbootjsf.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
