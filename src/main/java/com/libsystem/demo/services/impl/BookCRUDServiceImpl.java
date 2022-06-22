package com.libsystem.demo.services.impl;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libsystem.demo.model.Book;
import com.libsystem.demo.repo.IBookRepo;
import com.libsystem.demo.services.IBookCRUDService;

@Service
public class BookCRUDServiceImpl implements IBookCRUDService {

	@Autowired
	private IBookRepo bookRepo;

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
			return bookRepo.findById(null).get();
		}
		throw new Exception("You enter wrong ID!");
	}

	@Override
	public void deleteById(int id) {
		bookRepo.deleteById(id);
	}

	@Override
	public void updateById(int id, Book temp) throws Exception {
		if (bookRepo.existsById(id)) {
			Book book = bookRepo.findById(id).get();
			if (!book.getTitle().equals(temp.getTitle())) {
				book.setTitle(temp.getTitle());
			}
			if (temp.getAuthor() != book.getAuthor()) {
				book.setAuthor(temp.getAuthor());
			}
		} else {
			throw new Exception("Book is not found");
		}
	}

}
