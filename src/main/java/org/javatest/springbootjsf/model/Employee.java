package org.javatest.springbootjsf.model;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Data
@ManagedBean(name = "employee", eager = true)
@RequestScoped
@Entity
@Table(schema = "employees.public", name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column
    @NotNull(message = "Title cannot be null")
    private String title;

    @Column
    private Float price;

    @Column
    private String description;

    @Column
    private Integer nbofpage;

    @Column
    private Boolean illustrations;

}
