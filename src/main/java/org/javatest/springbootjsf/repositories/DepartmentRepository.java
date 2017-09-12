package org.javatest.springbootjsf.repositories;

import org.javatest.springbootjsf.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
