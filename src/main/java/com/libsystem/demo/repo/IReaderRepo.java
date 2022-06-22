package com.libsystem.demo.repo;


import org.springframework.data.repository.CrudRepository;

import com.libsystem.demo.model.Reader;

public interface IReaderRepo extends CrudRepository<Reader, Integer> {
    boolean existsByNameAndSurname(String name, String surname);
}
