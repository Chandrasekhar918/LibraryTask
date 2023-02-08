package com.LibraryMicroservice.service;

import com.LibraryMicroservice.exception.BookGenreNotFoundException;
import com.LibraryMicroservice.exception.BookNotFoundException;
import com.LibraryMicroservice.exception.BookTitleNotFoundException;
import com.LibraryMicroservice.model.BookDetails;
import com.LibraryMicroservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

   @Override
    public String deleteById(int bookId) {
    	bookRepository.deleteById(bookId);
    	return "Book deleted successfully";
    }
    @Override
    public BookDetails addBook(BookDetails bookDetails) throws BookNotFoundException {
        if (bookRepository.findById(bookDetails.getBookId()).isEmpty()) {
            return  bookRepository.save(bookDetails);
        }
        throw new BookNotFoundException("BookId already exists");
    }

    @Override
    public List<BookDetails> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public BookDetails updateBookById(int bookId, BookDetails bookDetails) throws BookNotFoundException {
        Optional<BookDetails> findById=bookRepository.findById(bookId);
        if(findById.isPresent()) {
            BookDetails updateBook=findById.get();
//            if(bookDetails.getBookName()!=null && !bookDetails.getBookName().isEmpty())
//                updateBook.setBookName(bookDetails.getBookName());
            if(bookDetails.getGenre()!=null && !bookDetails.getGenre().isEmpty())
                updateBook.setGenre(bookDetails.getGenre());
            if(bookDetails.getTitle()!=null && !bookDetails.getTitle().isEmpty())
                updateBook.setTitle(bookDetails.getTitle());
            if(bookDetails.getAuthor()!=null && !bookDetails.getAuthor().isEmpty())
                updateBook.setAuthor(bookDetails.getAuthor());
            if(bookDetails.getPrice()!=0)
                updateBook.setPrice(bookDetails.getPrice());
            return bookRepository.save(updateBook);
        }
        throw new BookNotFoundException("BookId not found");
    }


//    @Override
//    public  List<BookDetails> getByTitle(String title) throws BookTitleNotFoundException{
//        List<BookDetails> bookDetails = bookRepository.findByTitle(title);
////                .(() -> new BookTitleNotFoundException("No such title book is available"));
//        List<BookDetails> collect = bookDetails.stream().map(book -> {
//            book.getBookId();
//            book.getTitle();
//            book.getAuthor();
//            book.getGenre();
//            book.getPrice();
////            return book;
//        }).collect(Collectors.toList());
////        return collect;
//        return collect;
//    }






@Override
public List<BookDetails> getallByGenre(String genre) {
	// TODO Auto-generated method stub
	return bookRepository.findAllByGenre(genre);
}

@Override
public List<BookDetails> getallByAuthor(String author) {
	// TODO Auto-generated method stub
	return bookRepository.findAllByAuthor(author);
}

@Override
public BookDetails findTitle(String title) {
	// TODO Auto-generated method stub
	return bookRepository.findByTitle(title);
}



@Override
public BookDetails findBook(int bookId) {
	// TODO Auto-generated method stub
	return bookRepository.findById(bookId).get();
}
}


