package com.libsystem.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class LibEmployee {
    @Column(name = "IdEmpl")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idEmpl;

    @Column(name = "Name")
    @Size(min = 3, max = 30)
    @Pattern(regexp="[A-Z]{1}[a-z]+", message="First - capital letter, others are lowercase")
    private String name;

    @Column(name = "Surname")
    @Size(min = 3, max = 30)
    @Pattern(regexp="[A-Z]{1}[a-z]+", message="First - capital letter, others are lowercase")
    private String surname;
    
    // ManyToOne LibraryDep
    @ManyToOne
    @JoinColumn(name="IdDep")
    private LibraryDep libraryDep;

    // TODO Idea
    // employee login. When employee logs in to work, db shows boolean working = true, else false.


    public LibEmployee(@Size(min = 3, max = 30)
    @Pattern(regexp="[A-Z]{1}[a-z]+", message="First - capital letter, others are lowercase") String name,  @Size(min = 3, max = 30)
    @Pattern(regexp="[A-Z]{1}[a-z]+", message="First - capital letter, others are lowercase")
    String surname, LibraryDep libraryDep) {
        super();
        this.name= name;
        this.surname= surname;
        this.libraryDep = libraryDep;
    }
}
