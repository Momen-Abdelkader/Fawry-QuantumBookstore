package com.bookstore.services;

import com.bookstore.domain.Book;

public class ShippingService {
    public static void ship(Book book, int requestedQuantity, String address) {
        System.out.printf("Shipping %d copy(ies) of '%s' to: %s%n", requestedQuantity, book.getTitle(), address);
    }
}