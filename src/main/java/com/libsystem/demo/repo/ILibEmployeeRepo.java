package com.libsystem.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.libsystem.demo.model.LibEmployee;

public interface ILibEmployeeRepo extends CrudRepository<LibEmployee, Integer>{
    boolean existsByNameAndSurname(String name, String surname);
}
