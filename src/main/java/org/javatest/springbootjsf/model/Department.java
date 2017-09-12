package org.javatest.springbootjsf.model;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@ManagedBean(name = "department", eager = true)
@RequestScoped
@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column
    private String name;
}
