package com.LibraryMicroservice.exception;

public class BookTitleNotFoundException extends Exception{
    public BookTitleNotFoundException(String message) {
        super(message);
    }
}
