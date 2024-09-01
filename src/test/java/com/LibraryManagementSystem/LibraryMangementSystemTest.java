package com.LibraryManagementSystem;

import com.LibraryManagementSystem.Exceptions.BookAlreadyBorrowedException;
import com.LibraryManagementSystem.Exceptions.BookNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryMangementSystemTest {

    private LibraryMangementSystem library;

    @Test
    public void testcheck() {

        System.out.println("Test Module Running");
    }

    @BeforeEach
    public void setupLibrary() {
        library = new LibraryMangementSystem();
    }

    @Test
    public void testAddBookToLibrary() {
        String isbn = "78-0451524935";
        String author = "George Orwell";
        String title ="1984";
        library.addBook(isbn, title, author, 1949);
        assertNotNull(library.getBook("78-0451524935"), "Error: Book with ISBN " + isbn + " and title '" + title + "' should have been added but was not found.");
    }

    @Test
    public void testGetBookFromLibrary() throws BookNotFoundException {
        String isbn = "78-0451524935";
        String author = "George Orwell";
        library.addBook(isbn, "1984", author, 1949);
        Book book = library.getBook(isbn);
        assertEquals(isbn, book.getIsbn(), "Book ISBN should match.");
    }
    @Test
    public void testBorrowBookFromLibrary() throws BookNotFoundException, BookAlreadyBorrowedException {
        String isbn = "1234567890";
        library.addBook(isbn, "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.borrowBook(isbn);
        Book book = library.getBook(isbn);
        assertTrue(book.bookBorrowed(), "Book should be marked as borrowed after borrowing.");
    }
    @Test
    public void testReturnBook() throws BookNotFoundException, BookAlreadyBorrowedException {
        String isbn = "1234567890";
        library.addBook(isbn, "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.borrowBook(isbn);
        library.returnBook(isbn);
        Book book = library.getBook(isbn);
        assertFalse(book.isBorrowed(), "Book should not be borrowed after returning.");
    }
}
