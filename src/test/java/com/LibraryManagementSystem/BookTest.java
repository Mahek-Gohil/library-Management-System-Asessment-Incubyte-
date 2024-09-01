package com.LibraryManagementSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    public void testBooksetup() {
        Book book = new Book("78-0451524935", "1984", "George Orwell", 1949);
        assertEquals("78-0451524935", book.getIsbn());
        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertEquals(1949, book.getYear());
        assertFalse(book.isBorrowed(), "Book should not be borrowed initially");
    }
    @Test
    public void testBorrowBook() {
        Book book = new Book("78-0451524935", "1984", "George Orwell", 1949);
        book.borrow();
        assertTrue(book.isBorrowed(), "Book would be marked as borrowed after calling borrow()");
    }
    @Test
    public void testReturnBook() {
        Book book = new Book("78-0451524935", "1984", "George Orwell", 1949);
        book.borrow();
        book.returnBook();
        assertFalse(book.isBorrowed(), "Book should not be borrowed after returning");
    }

}
