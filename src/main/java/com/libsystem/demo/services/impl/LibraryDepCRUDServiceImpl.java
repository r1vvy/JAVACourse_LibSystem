package com.libsystem.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libsystem.demo.model.LibraryDep;
import com.libsystem.demo.repo.ILibraryDepRepo;
import com.libsystem.demo.services.ILibraryDepCRUDService;

@Service
public class LibraryDepCRUDServiceImpl implements ILibraryDepCRUDService {

	@Autowired
	private ILibraryDepRepo libraryRepo;

	@Override
	public void createLibraryDep(LibraryDep temp) throws Exception{
		if (libraryRepo.existsByLibSpec(temp.getLibSpec())) {
			throw new Exception("A department with this title already exists");
		} else {
			libraryRepo.save(temp);	
		}

	}

	@Override
	public ArrayList<LibraryDep> readAllLibraryDep() {
		return (ArrayList<LibraryDep>) libraryRepo.findAll();
	}

	@Override
	public LibraryDep readById(int id) throws Exception {
		if (libraryRepo.existsById(id)) {
			return libraryRepo.findById(id).get();
		}
		throw new Exception("You entered the wrong ID!");
	}

	@Override
	public void deleteById(int id) {
		libraryRepo.deleteById(id);
	}

	@Override
	public void updateById(int id, LibraryDep temp) throws Exception {
		if (libraryRepo.existsById(id)) {
			LibraryDep dep = libraryRepo.findById(id).get();

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
}
