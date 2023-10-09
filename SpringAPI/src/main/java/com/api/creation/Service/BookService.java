package com.api.creation.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.creation.Model.Books;
import com.api.creation.Repository.BookRepository;
@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	public List<Books> getallBooks() {
		List <Books>list=(List<Books>) bookRepository.findAll();
		return list;
	}
	public Books addBooks(Books books) {
		Books books2=this.bookRepository.save(books);
		return books2;
	
	}
	public Books getBookById(int id) {
		Books books=null;
		try {
			books=bookRepository.findById(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return books;
	}
	public void updateBooks(Books books, int id) {
		try {
			books.setId(id);
			bookRepository.save(books);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void deleteBooks(int id) {
		try {
			bookRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("No such book is registered");
		}
	}
	public List<Books> getBookCategory(String category) {
		List<Books>list=null;
		try {
			list=bookRepository.findByCategory(category);
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public List<Books> getBooksbyAuthor(String authorName) {
		List<Books>list=null;
		try {
			list=bookRepository.findByAuthorName(authorName);
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	

}
