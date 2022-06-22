package com.libsystem.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.libsystem.demo.model.LibraryDep;

public interface ILibraryDepRepo extends CrudRepository<LibraryDep, Integer>{
    boolean existsByLibSpec(String libSpec);
}
