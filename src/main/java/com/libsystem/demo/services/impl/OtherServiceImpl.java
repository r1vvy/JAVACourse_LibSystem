package com.libsystem.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libsystem.demo.model.Book;
import com.libsystem.demo.model.LibraryDep;
import com.libsystem.demo.model.RatingValue;
import com.libsystem.demo.repo.IBookRepo;
import com.libsystem.demo.repo.ILibraryDepRepo;
import com.libsystem.demo.repo.IReaderRepo;
import com.libsystem.demo.services.IOtherService;

@Service
public class OtherServiceImpl implements IOtherService {
    @Autowired
    private IBookRepo bookRepo;
    @Autowired
    private ILibraryDepRepo depRepo;
    @Autowired
    private IReaderRepo readerRepo;

    @Override
    public void addBookToLibDepById(Book book, int id) throws Exception {
        if (depRepo.existsById(id)) {
            LibraryDep dep = depRepo.findById(id).get();
            if (bookRepo.existsById(book.getIdBook())) {
                dep.getBooks().add(book);
                depRepo.save(dep);
            }
            else
                throw new Exception("Please add this book to the library first");
        }
        else
            throw new Exception("Department with this ID does not exist");
    }
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
