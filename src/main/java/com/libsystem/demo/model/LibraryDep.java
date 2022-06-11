package com.libsystem.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table
@Entity
public class LibraryDep {
    @Column(name = "IdDep")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idLibDep;

    @Column(name = "Specialization")
    private SpecValue libSpec;
    
    // TODO working hours regex or as time variable
    @Column(name = "WorkHours")
    private String workHours;

    // TODO relationships
    // OneToMany Books
    // OneToMany collection of this Dep employees.

    // bookQueForFutureCheckout what is that?

    public LibraryDep(SpecValue libSpec, String workHours) {
        super();
        this.libSpec = libSpec;
        this.workHours = workHours;
    }
}