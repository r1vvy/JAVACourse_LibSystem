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
import javax.validation.constraints.Pattern;

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
    @Pattern(regexp = "\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+", message = "First - capital letter. Name can't contain numbers.")
    private String author;

    @Column(name = "Year")
    // The Diamond Sutra - oldest dated printed book.
    @Min(868)
    private short year;

    @Column(name = "Rating")
    private RatingValue rating;

    @Column(name = "Condition")
    private ConditionValue condition;

    @Column(name = "Rarity")
    private RarityValue rarity;

	// ManyToOne LibraryDep
	@ManyToOne
	@JoinColumn(name = "IdRea")
	private Reader reader;

	// ManyToOne Reader
	@ManyToOne
	@JoinColumn(name = "IdDep")
	private LibraryDep libraryDep;


    public Book(String title, @Pattern(regexp = "\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+", message = "First - capital letter. Name can't contain numbers.") String author,
    @Min(868) short year, RatingValue rating, ConditionValue condition, RarityValue rarity) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
        this.rating = rating;
        this.condition = condition;
        this.rarity = rarity;
    }
}
