package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    // Atributo
    private final BookRepository bookRepository;

    // Constructor
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CRUD sobre la entidad Book

    //Buscar todos los libros
    @GetMapping("/api/books")
    public List<Book> findAll() {
        // Recuperar y devolver libros
        return bookRepository.findAll();
    }

    // Buscar libro por ID - Optional, no trabaja con null
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/api/books/{id}")
    // Anotación OpenApi
    @Operation(description = "Buscar un libro por clave primaria id Long.")
    public ResponseEntity<Book> findOneById(@PathVariable Long id) {

        Optional<Book> bookOpt = bookRepository.findById(id);

        // Opción 1
        if (bookOpt.isPresent()) {
            return ResponseEntity.ok(bookOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }

        // Opción 2
        /*
        return bookOpt.orElse(null);
        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
         */
    }

    // Crear nuevo libre

    /**
     *
     * @param book
     * @param headers
     * @return
     */
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers) {
        // Ver desde donde se hace la petición POST
        //System.out.println(headers.get("User-Agent"));
        if (book.getId() != null) {
            log.warn("Try to create a book with id");
            System.out.println("Try to create a book wit id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    // Actualizar un libro existente
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book) {
        if (book.getId() == null) {
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build(); // 400
        }
        if (!bookRepository.existsById(book.getId())) {
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build(); // 404
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    // Borrar base de datos
    @DeleteMapping("/api/books/{id}")
    // Anotación OpenApi - Oculto
    @Hidden
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            log.warn("Trying to delete   a non existent book");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/books")
    // Anotación OpenApi - Oculto
    @Hidden
    public ResponseEntity<Book> deleteAll() {
        if (bookRepository.count() == 0) {
            log.warn("Trying to delete an empty bata base");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
