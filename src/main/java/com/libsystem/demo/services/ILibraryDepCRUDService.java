package com.libsystem.demo.services;

import java.util.ArrayList;

import com.libsystem.demo.model.LibraryDep;

public interface ILibraryDepCRUDService {
	// CRUD

	// create

	public abstract void createLibraryDep(LibraryDep temp) throws Exception;

	// Read all

	public abstract ArrayList<LibraryDep> readAllLibraryDep();

	// Read By Id

	public abstract LibraryDep readById(int id) throws Exception;

	// Delete By ID

	public abstract void deleteById(int id);

	// Update By ID

	public abstract void updateById(int id, LibraryDep temp) throws Exception;
}
