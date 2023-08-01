package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class BookPriceCalculatorTest {

    @Test
    void calculatePriceTest() {
        // COnfiguración del test
        Book book = new Book(1L, "Harry Potter", "JK Rowlling", 500, 19.90, LocalDate.of(2019, 9, 30), true);

        // Ejecutamos test
        BookPriceCalculator calculator = new BookPriceCalculator();
        double price = calculator.calculatePrice(book);
        System.out.println(price);
        // Comprobar aserciones
        assertTrue(price > 0);
        assertEquals(27.89, price);
    }
}