package com.LibraryManagementSystem;

import com.LibraryManagementSystem.Book;
import com.LibraryManagementSystem.Exceptions.BookAlreadyBorrowedException;
import com.LibraryManagementSystem.Exceptions.BookNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem {
    private Map<String, Book> books;

    public LibraryManagementSystem() {
        // Initialization of HashMap.
        books = new HashMap<>();
    }

    //This method adds Book in HashMap named books.
    public void addBook(String isbn, String title, String author, int year) {
        if (!books.containsKey(isbn)) {
            Book newBook = new Book(isbn, title, author, year);
            books.put(isbn, newBook);
        }
    }

    //This method returns Book isbn if it's available in HashMap books.
    public Book getBook(String isbn) throws BookNotFoundException {
        if (!books.containsKey(isbn)) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        }
        return books.get(isbn);
    }

    /*This method allows user to borrow existing book from library.
     Method also checks if book is not already borrowed and if book exists in Library.*/
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

    //This method is used to return borrowed book to library.
    public void returnBook(String isbn) throws BookNotFoundException {
        Book book = getBook(isbn);
        book.returnBook();
    }
    //This method returns list of all available books.
    public List<Book> viewAllAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (!book.bookBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}