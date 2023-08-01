package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;

public class BookPriceCalculator {

    // Test para jUnit
    public double calculatePrice(Book book) {
        double price = book.getPrice();

        if (book.getPages() > 300) {
            price += 5;
        }
        // Envío
        price += 2.99;
        return price;

    }

}
