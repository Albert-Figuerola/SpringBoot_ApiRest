package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void hello() {
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("/hola", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hola que tal estás World?", response.getBody());
    }

    @Test
    void findAll() {
        ResponseEntity<Book[]> response =
        testRestTemplate.getForEntity("/api/books", Book[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Book> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Book> response =
                testRestTemplate.getForEntity("/api/books/2", Book.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Hola que tal estás World?", response.getBody());
    }

    @Test
    void create() {
    }
}