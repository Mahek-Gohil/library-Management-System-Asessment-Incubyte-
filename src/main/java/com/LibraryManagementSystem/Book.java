package com.LibraryManagementSystem;
//Declaration
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean bookBorrowed;
//Initialization
    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.bookBorrowed = false;
    }
    //Gives ISBN for specified book.
    public String getIsbn() {
        return isbn;
    }
    //Gives title for specified book.
    public String getTitle() {
        return title;
    }
    //Gives author name for specified book.
    public String getAuthor() {
        return author;
    }
    //Gives published year for specified book.
    public int getYear() {
        return year;
    }

    public boolean bookBorrowed() {
        return bookBorrowed;
    }

    public void borrowBook() {
        bookBorrowed = true;
    }

    public void returnBook() {
        bookBorrowed = false;
    }
}


