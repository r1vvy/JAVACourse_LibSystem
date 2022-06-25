package com.libsystem.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libsystem.demo.model.Book;
import com.libsystem.demo.model.RatingValue;
import com.libsystem.demo.repo.IBookRepo;
import com.libsystem.demo.repo.IReaderRepo;
import com.libsystem.demo.services.IOtherService;

@Service
public class OtherServiceImpl implements IOtherService {
    @Autowired
    private IBookRepo bookRepo;
    @Autowired
    private IReaderRepo readerRepo;

    @Override
    public ArrayList<Book> selectAllBooksTakenByReaderId(int id) throws Exception {
        if(readerRepo.existsById(id))
            return (ArrayList<Book>) readerRepo.findById(id).get().getBooks();
        else
            throw new Exception("Reader with this ID does not exist!");
    }
    @Override
    public ArrayList<Book> selectAllBooksByAuthor(String author) {
            return (ArrayList<Book>) bookRepo.findByAuthor(author);
    }

    @Override
    public ArrayList<Book> selectAllBooksByRatingVal(RatingValue ratingVal) {
        return (ArrayList<Book>) bookRepo.findByRatingVal(ratingVal);
    }
}
