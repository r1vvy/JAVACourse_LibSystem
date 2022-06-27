package com.libsystem.demo;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.libsystem.demo.model.Book;
import com.libsystem.demo.model.ConditionValue;
import com.libsystem.demo.model.LibEmployee;
import com.libsystem.demo.model.LibraryDep;
import com.libsystem.demo.model.RarityValue;
import com.libsystem.demo.model.RatingValue;
import com.libsystem.demo.model.Reader;
import com.libsystem.demo.repo.IBookRepo;
import com.libsystem.demo.repo.ILibEmployeeRepo;
import com.libsystem.demo.repo.ILibraryDepRepo;
import com.libsystem.demo.repo.IReaderRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
		public CommandLineRunner testdb(IBookRepo bookRepo, ILibEmployeeRepo employeeRepo,
		ILibraryDepRepo depRepo, IReaderRepo readerRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				LibraryDep libraryDep1 = new LibraryDep("Literature and Fiction", "Work days 9:00 - 6:00 PM");
				LibraryDep libraryDep2 = new LibraryDep("Theatre", "Work days 9:00 - 6:00 PM");
				depRepo.save(libraryDep1);
				depRepo.save(libraryDep2);
				
				Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K Rowling", 2001, RatingValue.five_stars, 
				ConditionValue.as_new, RarityValue.signed, libraryDep1);
				Book book2 = new Book("Romeo un Džuljeta", "Viljams Sekspirs", 1597, RatingValue.five_stars, 
				ConditionValue.fine, RarityValue.first_edition, libraryDep2);
				bookRepo.save(book1);
				bookRepo.save(book2);

				LibEmployee employee1 = new LibEmployee("Janis", "Berzins", libraryDep1);
				LibEmployee employee2 = new LibEmployee("Will", "Notsmith", libraryDep2);

				employeeRepo.save(employee1);
				employeeRepo.save(employee2);

				Reader reader1 = new Reader("Olafs", "Rozentals");
				Reader reader2 = new Reader("Mairis", "Buks");

				readerRepo.save(reader1);
				readerRepo.save(reader2);
			}	
		};
	}
}
