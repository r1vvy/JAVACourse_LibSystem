package com.libsystem.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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
	private String name;

	@Column(name = "Surname")
	@Size(min = 3, max = 30)
	private String surname;
	
	// viens pret daudziem
	
	@OneToMany(mappedBy = "reader")
	@ToString.Exclude
	private Collection<Book> books;

	public Reader(@Size(min = 3, max = 30) String name, @Size(min = 3, max = 30) String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	
}
