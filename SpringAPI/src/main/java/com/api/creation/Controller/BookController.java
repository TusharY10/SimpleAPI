package com.api.creation.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.creation.Model.Books;
import com.api.creation.Service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Books>> getallBooks() {
		List<Books>list=bookService.getallBooks();
		if (list.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	@PostMapping("/books")
	public Books addBooks(@RequestBody Books books) {
		return this.bookService.addBooks(books);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getBookById(@PathVariable int id) {
		Books books=bookService.getBookById(id);
		if (books==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(books));
	}
	@PutMapping("/books/{id}")
	public ResponseEntity<Books> updateBooks(@RequestBody Books books, @PathVariable int id) {
		try {
			this.bookService.updateBooks(books,id);
			return ResponseEntity.ok().body(books);
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
	}
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Books> deleteById(@PathVariable int id){
		try {
			this.bookService.deleteBooks(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/books/")
	public ResponseEntity<List<Books>> getBookByCategory(@RequestParam String category){
		List<Books>books=bookService.getBookCategory(category);
		if (books==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).build();	
		}
	}

}
