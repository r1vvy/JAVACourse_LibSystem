package com.libsystem.demo.services;

import java.util.ArrayList;

import com.libsystem.demo.model.Reader;

public interface IReaderCRUDService {
	
	public abstract void addNewReader(Reader temp) throws Exception;

	public abstract ArrayList<Reader> readAllReaders();
	
	public abstract Reader selectById(int id) throws Exception;
	
	public abstract void deleteById(int id);
	
	public abstract void updateById(int id, Reader temp) throws Exception;
}
