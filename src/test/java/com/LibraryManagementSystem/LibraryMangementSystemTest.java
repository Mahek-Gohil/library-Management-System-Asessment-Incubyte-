package com.LibraryManagementSystem;

import com.LibraryManagementSystem.LibraryMangementSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryMangementSystemTest {

     private LibraryMangementSystem library;
     @Test
    public void testcheck(){
        System.out.println("Test Module Running");
    }
    @BeforeEach
    public void setupLibrary(){
        library = new LibraryMangementSystem();
    }

        @Test
    public void testAddBookToLibrary() {
        String isbn ="78-0451524935";
        String title="\"George Orwell\"";
        library.addBook(isbn, "1984",title , 1949);
        assertNotNull(library.getBook("78-0451524935"),"Error: Book with ISBN " + isbn + " and title '" + title + "' should have been added but was not found.");
    }

}
