package com.libsystem.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libsystem.demo.model.Reader;
import com.libsystem.demo.repo.IReaderRepo;
import com.libsystem.demo.services.IReaderCRUDService;

@Service
public class ReaderCRUDServiceImpl implements IReaderCRUDService {

	@Autowired
	private IReaderRepo readerRepo;

	@Override
	public void addNewReader(Reader temp) throws Exception {
		if (readerRepo.existsByNameAndSurname(temp.getName(), temp.getSurname())) {
			throw new Exception("A reader with this name and surname already exists!");
		} else {
			readerRepo.save(temp);
		}
	}

	@Override
	public ArrayList<Reader> readAllReaders() {
		return (ArrayList<Reader>) readerRepo.findAll();
	}

	@Override
	public Reader selectById(int id) throws Exception {
		if (readerRepo.existsById(id)) {
			return readerRepo.findById(id).get();
		}
		throw new Exception("You entered the wrong ID!");
	}

	@Override
	public void deleteById(int id) {
		readerRepo.deleteById(id);

	}

	@Override
	public void updateById(int id, Reader temp) throws Exception {
		if (readerRepo.existsById(id)) {
			Reader read = readerRepo.findById(id).get();

			if (!read.getName().equals(temp.getName())) {
				read.setName(temp.getName());
			}
			if (temp.getSurname() != read.getSurname()) {
				read.setSurname(temp.getSurname());
			}
		} else {
			throw new Exception("Reader is not found!");
		}
	}

}
