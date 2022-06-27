package com.libsystem.demo.services.impl;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libsystem.demo.model.Book;
import com.libsystem.demo.model.Reader;
import com.libsystem.demo.repo.IBookRepo;
import com.libsystem.demo.repo.IReaderRepo;
import com.libsystem.demo.services.IBookCRUDService;

@Service
public class BookCRUDServiceImpl implements IBookCRUDService {

	@Autowired
	private IBookRepo bookRepo;

	@Autowired
	private IReaderRepo readerRepo;

	@Override
	public void addNewBook(Book temp) {
		bookRepo.save(temp);
	}

	@Override
	public ArrayList<Book> selectAllBooks() {
		return (ArrayList<Book>) bookRepo.findAll();
	}

	@Override
	public Book selectById(int id) throws Exception {
		if (bookRepo.existsById(id)) {
			return bookRepo.findById(id).get();
		}
		throw new Exception("You entered the wrong ID!");
	}

	@Override
	public void deleteById(int id) throws Exception{
		if(bookRepo.existsById(id))
			bookRepo.deleteById(id);
		else
			throw new Exception("A book with this ID does not exist");
	}

	@Override
	public void updateById(int id, Book temp) throws Exception {
		if (bookRepo.existsById(id)) {
			Book book = bookRepo.findById(id).get();
			if (!book.getTitle().equals(temp.getTitle())) {
				book.setTitle(temp.getTitle());
			}
			if (!book.getAuthor().equals(temp.getAuthor())) {
				book.setAuthor(temp.getAuthor());
			}
			if (!book.getConditionVal().equals(temp.getConditionVal())) {
				book.setConditionVal(temp.getConditionVal());
			}
			if (!book.getRarityVal().equals(temp.getRarityVal())) {
				book.setRarityVal(temp.getRarityVal());
			}
			if (!book.getRatingVal().equals(temp.getRatingVal())) {
				book.setRatingVal(temp.getRatingVal());
			}
			if (!book.getLibraryDep().equals(temp.getLibraryDep())) {
				book.setLibraryDep(temp.getLibraryDep());
			}
			bookRepo.save(book);
		} else {
			throw new Exception("Book is not found");
		}
	}
	public void addReader(int bookId, int readerId) throws Exception {
		if(!readerRepo.existsById(readerId) && !bookRepo.existsById(bookId)) {
			throw new Exception("Reader or book with supplied ID doesnt exist!");
		} else {
			Book book = bookRepo.findById(bookId).get();
			Reader reader = readerRepo.findById(readerId).get();
			book.setReader(reader);
			bookRepo.save(book);
		}
	}
	public void removeReader(int id) throws Exception {
		if(!bookRepo.existsById(id)) {
			throw new Exception("Book with supplied ID doesnt exist!");
		} else {
			Book book = bookRepo.findById(id).get();
			if(!book.getReader().equals(null)) {
				book.setReader(null);
				bookRepo.save(book);
			}
			else
				throw new Exception("The book has no current reader!");
		}
	}
}
