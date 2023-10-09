package com.api.creation.Repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.api.creation.Model.Books;
@Repository
public interface BookRepository extends CrudRepository<Books, Integer>{

	public Books findById(int id);	
	
	public List<Books> findByCategory(String category);
	
	public List<Books> findByAuthorName(String authorName);
}