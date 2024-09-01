package com.LibraryManagementSystem;

import com.LibraryManagementSystem.Exceptions.BookAlreadyBorrowedException;
import com.LibraryManagementSystem.Exceptions.BookNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryManagementSystemTest {

    private LibraryManagementSystem library;

    @Test
    public void testCheck() {
        //Initial test case to check working of JUnit5 module.
        System.out.println("Test Module Running");
    }

    @BeforeEach
    public void setupLibrary() {
        //Initialize object before each test case.
        library = new LibraryManagementSystem();
    }

    @Test
    public void testAddBookToLibrary() throws BookNotFoundException {
        //Test for adding book.
        String isbn = "78-0451524935";
        String author = "George Orwell";
        String title ="1984";
        library.addBook(isbn, title, author, 1949);
        assertNotNull(library.getBook("78-0451524935"), "Error: Book with ISBN " + isbn + " and title '" + title + "' should have been added but was not found.");
    }

    @Test
    public void testGetBookFromLibrary() throws BookNotFoundException {
        //Test for fetching book with isbn no. .
        String isbn = "78-0451524935";
        String author = "George Orwell";
        library.addBook(isbn, "1984", author, 1949);
        Book book = library.getBook(isbn);
        assertEquals(isbn, book.getIsbn(), "Book ISBN should match.");
    }
    @Test
    public void testBorrowBookFromLibrary() throws BookNotFoundException, BookAlreadyBorrowedException {
        //Test to borrow available book from library.
        String isbn = "78-0451524935";
        library.addBook(isbn, "1984", "George Orwell", 1949);
        library.borrowBook(isbn);
        Book book = library.getBook(isbn);
        assertTrue(book.bookBorrowed(), "Book should be marked as borrowed after borrowing.");
    }
    @Test
    public void testReturnBook() throws BookNotFoundException, BookAlreadyBorrowedException {
        //Test to return borrowed book.
        String isbn = "78-0451524935";
        library.addBook(isbn, "1984", "George Orwell", 1949);
        library.borrowBook(isbn);
        library.returnBook(isbn);
        Book book = library.getBook(isbn);
        assertFalse(book.bookBorrowed());
    }
    @Test
    public void testBookNotFound() {
        // Test for a book that doesn't exist.
        assertThrows(BookNotFoundException.class, () -> {
            library.getBook("41-7643210941"); // Non-existent ISBN
        }, "BookNotFoundException would be thrown for non-existing ISBN.");
    }
    @Test
    public void testBookAlreadyBorrowed() throws BookNotFoundException, BookAlreadyBorrowedException {
        //Test for book that are already borrowed.
        String isbn = "78-0451524935";
        library.addBook(isbn, "1984", "George Orwell", 1949);
        library.borrowBook(isbn);

        assertThrows(BookAlreadyBorrowedException.class, () -> {
            library.borrowBook(isbn);
        }, "BookAlreadyBorrowedException would be thrown if the book is already borrowed.");
    }
    @Test
    public void testViewAvailableBooksWhereAllBooksAreAvailable() throws BookNotFoundException, BookAlreadyBorrowedException {
        //Test for viewing all available books.
        String isbn = "978-0439139601";
        library.addBook("978-0451524935","1984", "George Orwell", 1949);
        library.addBook("978-0439139601","Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000);
        library.addBook("978-0140449136","The Odyssey","Homer",800);
        library.addBook("978-0316769488","The Catcher in the Rye","J.D. Salinger",1951);
        library.borrowBook(isbn);
        List<Book> availableBooks = library.viewAllAvailableBooks();
        assertEquals(3, availableBooks.size(), "Three books should be available.");
        assertEquals("1984", availableBooks.get(1).getTitle(), "The available book should be '1984'.");
    }

}
