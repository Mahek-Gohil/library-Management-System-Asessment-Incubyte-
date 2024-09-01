package com.LibraryManagementSystem;

import com.LibraryManagementSystem.Book;
import com.LibraryManagementSystem.Exceptions.BookAlreadyBorrowedException;
import com.LibraryManagementSystem.Exceptions.BookNotFoundException;

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
    public void borrowBook(String isbn) throws BookNotFoundException, BookAlreadyBorrowedException {
        Book book = books.get(isbn);
        if (book == null) {
            throw new BookNotFoundException("Error: Book with ISBN " + isbn + " not found.");
        }
        if (book.bookBorrowed()) {
            throw new BookAlreadyBorrowedException("Error: Book with ISBN " + isbn + " is already borrowed.");
        }
        book.borrowBook();
    }
}
