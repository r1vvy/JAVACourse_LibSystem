package com.libsystem.demo.services;

import java.util.ArrayList;

import com.libsystem.demo.model.Book;
import com.libsystem.demo.model.RatingValue;

public interface IOtherService {
    public abstract ArrayList<Book> selectAllBooksTakenByReaderId(int id) throws Exception;
    public abstract ArrayList<Book> selectAllBooksByAuthor(String author) throws Exception;
    public abstract ArrayList<Book> selectAllBooksByRatingVal(RatingValue ratingVal);
    // TODO conditionVal, rarityVal, notTaken selectBooks
}
