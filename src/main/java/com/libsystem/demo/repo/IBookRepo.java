package com.libsystem.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.libsystem.demo.model.Book;

public interface IBookRepo extends CrudRepository<Book, Integer>{
    
}
