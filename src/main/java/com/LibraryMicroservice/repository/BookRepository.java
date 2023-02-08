package com.LibraryMicroservice.repository;

import com.LibraryMicroservice.model.BookDetails;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<BookDetails, Integer> {

	List<BookDetails> findAllByGenre(String genre);
	List<BookDetails> findAllByAuthor(String author);
	BookDetails findByTitle(String title);

}
