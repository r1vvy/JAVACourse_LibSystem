package com.libsystem.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

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
public class Book {
    @Column(name = "IdBook")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idBook;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "Year")
    // The Diamond Sutra - oldest dated printed book.
    @Min(868)
    private int year;

    @Column(name = "RatingVal")
    private RatingValue ratingVal;

    @Column(name = "ConditionVal")
    private ConditionValue conditionVal;

    @Column(name = "RarityVal")
    private RarityValue rarityVal;

	// ManyToOne LibraryDep
	@ManyToOne
	@JoinColumn(name = "IdRea")
	private Reader reader;

	// ManyToOne Reader
	@ManyToOne
	@JoinColumn(name = "IdDep")
	private LibraryDep libraryDep;

    public Book(String title, String author,
    @Min(868) int year, RatingValue rating, ConditionValue condition, RarityValue rarity, LibraryDep libraryDep) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
        this.ratingVal = rating;
        this.conditionVal = condition;
        this.rarityVal = rarity;
        this.libraryDep = libraryDep;
    }
}
