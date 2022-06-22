package com.libsystem.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    // TODO regex
    @Column(name = "Specialization")
    private String libSpec;
    
    // TODO working hours regex or as time variable
    @Column(name = "WorkHours")
    private String workHours;


	// OneToMany Books
	@OneToMany(mappedBy = "libraryDep")
    @ToString.Exclude
	private Collection<Book> books;

	// OneToMany collection of this Dep employees.
	@OneToMany(mappedBy = "libraryDep")
    @ToString.Exclude
	private Collection<LibEmployee> libEmployees;

	// bookQueForFutureCheckout - Sagatavo sarakstu grāmatai,
	// ka lasītājs var nākotne jau rezervēt grāmatu

    public LibraryDep(String libSpec, String workHours) {
        super();
        this.libSpec = libSpec;
        this.workHours = workHours;
    }
}
