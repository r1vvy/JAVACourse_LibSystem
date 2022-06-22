package com.libsystem.demo.services;

import java.util.ArrayList;

import com.libsystem.demo.model.Book;

public interface IBookCRUDService {


	public abstract void addNewBook(Book temp);

	public abstract ArrayList<Book> selectAllBooks();
	
	public abstract Book selectById(int id) throws Exception;
	
	public abstract void deleteById(int id);
	
	public abstract void updateById(int id, Book temp) throws Exception;

	
}
