package org.javatest.springbootjsf.model;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@ManagedBean(name = "employee", eager = true)
@RequestScoped
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Long departmentId;

}
