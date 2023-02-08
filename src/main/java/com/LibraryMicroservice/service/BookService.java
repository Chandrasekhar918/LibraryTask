package com.LibraryMicroservice.service;

import com.LibraryMicroservice.exception.BookAuthorNotFoundException;
import com.LibraryMicroservice.exception.BookGenreNotFoundException;
import com.LibraryMicroservice.exception.BookNotFoundException;
import com.LibraryMicroservice.exception.BookTitleNotFoundException;
import com.LibraryMicroservice.model.BookDetails;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<BookDetails> findAll();
    BookDetails addBook(BookDetails bookDetails) throws BookNotFoundException;
    
  public String  deleteById(int bookId);
    BookDetails updateBookById(int bookId, BookDetails bookDetails) throws BookNotFoundException;
//    List<BookDetails> getByTitle(String Title) throws BookTitleNotFoundException;
    //List<BookDetails> findByGenre(String Genre) throws BookGenreNotFoundException;
//    List<BookDetails> findByAuthor(String Author) throws BookAuthorNotFoundException;
public BookDetails findBook(int bookId);
    public List<BookDetails> getallByGenre(String genre);
    public List<BookDetails> getallByAuthor(String author);
    public BookDetails findTitle(String title);
}
