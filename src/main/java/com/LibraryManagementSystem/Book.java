package com.LibraryManagementSystem;

public class Book {
    private int isbn;
    private String title;
    private String author;
    private int year;
    private boolean isBorrowed;

    public Book(int isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isBorrowed = false;
    }
}
