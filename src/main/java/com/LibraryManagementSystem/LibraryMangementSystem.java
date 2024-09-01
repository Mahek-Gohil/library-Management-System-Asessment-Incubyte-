package com.LibraryManagementSystem;

import com.LibraryManagementSystem.Book;

import java.util.HashMap;
import java.util.Map;

public class LibraryMangementSystem {
    private Map<String, Book> books;

    public LibraryMangementSystem() {
        // Initaialization of HashMap
        books = new HashMap<>();
    }
     //This method adds Book in HashMap named books
    public void addBook(String isbn, String title, String author, int year) {
        if (!books.containsKey(isbn)) {
            Book newBook = new Book(isbn, title, author, year);
            books.put(isbn, newBook);
        }
    }
    //This method returns Book isbn if it's available in HashMap books
    public Book getBook(String isbn) {
        return books.get(isbn);
    }
}
