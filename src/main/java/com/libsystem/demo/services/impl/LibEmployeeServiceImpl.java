package com.libsystem.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libsystem.demo.model.LibEmployee;
import com.libsystem.demo.repo.ILibEmployeeRepo;
import com.libsystem.demo.services.ILibEmployeeService;

@Service
public class LibEmployeeServiceImpl implements ILibEmployeeService{
    @Autowired
    ILibEmployeeRepo employeeRepo;
    
    public void addNewEmployee(LibEmployee employee) throws Exception{
        if (employeeRepo.existsByNameAndSurname(employee.getName(), employee.getSurname())) {
			throw new Exception("Employee exists already");
		} else {
			employeeRepo.save(employee);	
		}
    }

	public ArrayList<LibEmployee> selectAllEmployees() {
        return (ArrayList<LibEmployee>) employeeRepo.findAll();
    }
	
	public LibEmployee selectById(int id) throws Exception {
        if (employeeRepo.existsById(id)) {
			return employeeRepo.findById(id).get();
		}
		throw new Exception("You entered the wrong ID!");
    }
	
	public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }
	
	public void updateById(int id, LibEmployee temp) throws Exception {
        if (employeeRepo.existsById(id)) {
			LibEmployee employee = employeeRepo.findById(id).get();

			if (!employee.getName().equals(temp.getName())) {
				employee.setName(temp.getName());
			}
            if (!employee.getSurname().equals(temp.getSurname())) {
				employee.setSurname(temp.getSurname());
			}
            if (!employee.getSurname().equals(temp.getSurname())) {
				employee.setSurname(temp.getSurname());
			}
            if (!employee.getLibraryDep().equals(temp.getLibraryDep())) {
				employee.setLibraryDep(temp.getLibraryDep());
			}
            employeeRepo.save(employee);
		} else {
			throw new Exception("Library employee is not found");

		}
    }
}
