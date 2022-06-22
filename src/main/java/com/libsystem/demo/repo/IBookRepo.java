package com.libsystem.demo.repo;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.libsystem.demo.model.Book;
import com.libsystem.demo.model.RatingValue;

public interface IBookRepo extends CrudRepository<Book, Integer>{
    boolean existsByTitle(String title);
    Book findByTitle(String title);
    Collection<Book> findByAuthor(String author);
    Collection<Book> findByRatingVal(RatingValue ratingVal);
}
