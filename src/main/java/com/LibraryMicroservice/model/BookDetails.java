package com.LibraryMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="BookDetails")
public class BookDetails {

    @Id
    private int bookId;
//    @NotNull
//    private String BookName;
    @NotNull
    private String title;
    @NotBlank(message = "Genre cant be null nor empty")
    private String genre;
    @NotNull
    private String author;
    @NotNull
    private int Price;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
    
    
}
