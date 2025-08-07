package com.bookstore.domain;

import com.bookstore.interfaces.IShippable;

import java.time.Year;
import java.util.*;

public class Inventory {
    private final Map<String, Book> inventory = new HashMap<>(); // ISBN -> Book

    public void addBook(Book book) {
        String isbn = book.getIsbn();
        Book existingBook = inventory.get(isbn);

        if (existingBook == null) {
            inventory.put(isbn, book);
            return;
        }

        // increase stock if the existing and new books are both shippable
        if (existingBook instanceof IShippable existingShippable && book instanceof IShippable newShippable) {

            // make sure book details match
            if (!existingBook.getTitle().equals(book.getTitle())
                || existingBook.getYear() != book.getYear()
                || Math.abs(existingBook.getPrice() - book.getPrice()) > 0.001
                || Math.abs(existingShippable.getWeight() - newShippable.getWeight()) > 0.001) {
                throw new IllegalArgumentException("Book details mismatch for ISBN: " + isbn);
            }

            existingShippable.increaseStock(newShippable.getStock());
        }
        // replace the existing book if both the new and existing books are not shippable
        else {
            inventory.put(isbn, book);
        }
    }

    public void removeBook(Book book) {
        if (!inventory.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Book not found in inventory.");
        }

        inventory.remove(book.getIsbn());
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public List<Book> removeOutDatedBooks(int maxYearsPassed) {
        int currentYear = Year.now().getValue();
        List<Book> outdatedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            int yearsPassed = currentYear - book.getYear();

            if (yearsPassed > maxYearsPassed) {
                outdatedBooks.add(book);
                iterator.remove();
            }
        }
        return outdatedBooks;
    }
}
