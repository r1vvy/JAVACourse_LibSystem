package com.libsystem.demo.services;

import java.util.ArrayList;

import com.libsystem.demo.model.Book;
import com.libsystem.demo.model.Reader;

public interface IBookCRUDService {


	public abstract void addNewBook(Book temp);

	public abstract ArrayList<Book> selectAllBooks();
	
	public abstract Book selectById(int id) throws Exception;
	
	public abstract void deleteById(int id) throws Exception;
	
	public abstract void updateById(int id, Book temp) throws Exception;

	public abstract void addReader(int bookId, int readerId) throws Exception;
	public abstract void removeReader(int id) throws Exception;


	
}
