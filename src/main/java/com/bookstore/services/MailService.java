package com.bookstore.services;

import com.bookstore.domain.Book;

public class MailService {
    public static void sendEmail(Book book, String email, String fileType) {
        System.out.printf("Sending '%s' (%s format) to: %s%n", book.getTitle(), fileType, email);
    }
}
