package com.libsystem.demo.services;

import java.util.ArrayList;

import com.libsystem.demo.model.LibEmployee;

public interface ILibEmployeeService {
    
	public abstract void addNewEmployee(LibEmployee employee) throws Exception;

	public abstract ArrayList<LibEmployee> selectAllEmployees();
	
	public abstract LibEmployee selectById(int id) throws Exception;
	
	public abstract void deleteById(int id);
	
	public abstract void updateById(int id, LibEmployee temp) throws Exception;
}
