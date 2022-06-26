package com.libsystem.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libsystem.demo.model.Book;
import com.libsystem.demo.model.LibraryDep;
import com.libsystem.demo.repo.IBookRepo;
import com.libsystem.demo.repo.ILibraryDepRepo;
import com.libsystem.demo.services.ILibraryDepCRUDService;

@Service
public class LibraryDepCRUDServiceImpl implements ILibraryDepCRUDService {

	@Autowired
	private ILibraryDepRepo depRepo;

	@Autowired
	private IBookRepo bookRepo;

	@Override
	public void createLibraryDep(LibraryDep temp) throws Exception{
		if (depRepo.existsByLibSpec(temp.getLibSpec())) {
			throw new Exception("A department with this title already exists");
		} else {
			depRepo.save(temp);	
		}
	}

	@Override
	public ArrayList<LibraryDep> readAllLibraryDep() {
		return (ArrayList<LibraryDep>) depRepo.findAll();
	}

	@Override
	public LibraryDep readById(int id) throws Exception {
		if (depRepo.existsById(id)) {
			return depRepo.findById(id).get();
		}
		throw new Exception("You entered the wrong ID!");
	}

	@Override
	public void deleteById(int id) {
		depRepo.deleteById(id);
	}

	@Override
	public void updateById(int id, LibraryDep temp) throws Exception {
		if (depRepo.existsById(id)) {
			LibraryDep dep = depRepo.findById(id).get();

			if (!dep.getLibSpec().equals(temp.getLibSpec())) {
				dep.setLibSpec(temp.getLibSpec());
			}
			if (temp.getWorkHours().equals(dep.getWorkHours())) {
				dep.setWorkHours(temp.getWorkHours());
			}
		} else {
			throw new Exception("Library Department is not found");

		}
	}

	@Override
	public ArrayList<Book> selectAllBooksInLibDepByLibDepId(int id) throws Exception {
		if(depRepo.existsById(id)) {
			return (ArrayList<Book>) depRepo.findById(id).get().getBooks();
		}
		else
			throw new Exception("Library Department with this ID does not exist!");
	}
}
