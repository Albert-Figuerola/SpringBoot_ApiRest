package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);

		BookRepository repository = context.getBean(BookRepository.class);
		// CRUD - Lo de abajo debería hacerlo un servicio
		// Crear un libro
		Book book1 = new Book(null, "Harry Potter", "JK Rowlling", 500, 19.90, LocalDate.of(2019,9,30),true);
		Book book2 = new Book(null, "El mundo màgico", "Terry Pratchet", 200, 12.90, LocalDate.of(2015,9,30),true);
		Book book3 = new Book(null, "El temor de un hombre sabio", "Un autor", 500, 16.90, LocalDate.of(2012,9,30),false);

		System.out.println("Libros antes: " + repository.findAll().size());

		// Almacenar un libro
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);

		// Recuperar todos los libros
		System.out.println("Libros después de insertar: " + repository.findAll().size());
		//System.out.println(repository.findAll());
		System.out.println("ID 2: " + repository.findById(2L));

		// Borrar un libro
		//repository.deleteById(2L);

		System.out.println("Libros después de borrar: " + repository.findAll().size());

	}

}
