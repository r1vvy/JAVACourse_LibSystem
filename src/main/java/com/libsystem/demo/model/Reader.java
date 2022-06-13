package com.libsystem.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reader {

	@Setter(value = AccessLevel.NONE)
	@Id
	@Column(name = "IdRea")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRea;

	@Column(name = "Name")
	@Size(min = 3, max = 30)
	@Pattern(regexp = "\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+", message = "First - capital letter. Name can't contain numbers.")
	private String name;

	@Column(name = "Surname")
	@Size(min = 3, max = 30)
	@Pattern(regexp = "\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+", message = "First - capital letter. Name can't contain numbers.")
	private String surname;
	
	private Collection<Book> bookHistory;
	
	// viens pret daudziem
	@OneToMany(mappedBy = "reader")
	@ToString.Exclude
	private Collection<Book> books;

	public Reader(@Size(min = 3, max = 30)
	@Pattern(regexp = "\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+", message = "First - capital letter. Name can't contain numbers.")
	String name, 
	@Size(min = 3, max = 30)
	@Pattern(regexp = "\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+", message = "First - capital letter. Name can't contain numbers.")
	String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	
}
