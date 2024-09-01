package com.LibraryManagementSystem;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean bookBorrowed;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.bookBorrowed = false;
    }
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

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


