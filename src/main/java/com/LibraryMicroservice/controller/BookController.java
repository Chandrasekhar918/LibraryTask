package com.LibraryMicroservice.controller;

import com.LibraryMicroservice.exception.BookNotFoundException;
import com.LibraryMicroservice.exception.BookTitleNotFoundException;
import com.LibraryMicroservice.model.BookDetails;
import com.LibraryMicroservice.repository.BookRepository;
import com.LibraryMicroservice.service.BookService;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @DeleteMapping("/del/{bookId}")
    public String delete(@PathVariable int bookId) {
    	return bookService.deleteById(bookId);
    }
    
@GetMapping("/find/{bookId}")
public BookDetails findBook(@PathVariable int bookId) {
	return bookService.findBook(bookId);
}

@GetMapping("/getauthor/{author}")
public List<BookDetails> findAuthor(String author){
	return bookService.getallByAuthor(author);
}

@GetMapping("/title/{title}")
public BookDetails findTitle(String title){
	return bookService.findTitle(title);
}
@GetMapping("/getgenre/{genre}")
public List<BookDetails> findGenre(String genre){
	return bookService.getallByGenre(genre);
}

@PutMapping("/update/{bookId}")
public BookDetails update(@RequestBody BookDetails lib,@PathVariable int bookId) throws BookNotFoundException {
	return bookService.updateBookById(bookId, lib);
}
    @PostMapping("/addBook")
    @ApiOperation(value = "Add Book to the list")
    public ResponseEntity<BookDetails> addCustomer(@RequestBody BookDetails bookDetails)
            throws BookNotFoundException {
        BookDetails bookDetails1 = bookService.addBook(bookDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDetails1);
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Get Book list")
    public ResponseEntity<List<BookDetails>> getAllCustomers() {

        List<BookDetails> bookDetails = bookService.findAll();
        if (bookDetails.isEmpty()) {

            return new ResponseEntity<List<BookDetails>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<BookDetails>>(bookDetails, HttpStatus.OK);
    }
   
//    @DeleteMapping("/deleteBook/{id}")
//    @ApiOperation(value = "Delete book detail")

    
}
