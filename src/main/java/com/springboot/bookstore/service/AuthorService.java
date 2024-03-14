package com.springboot.bookstore.service;

import java.util.List;

import com.springboot.bookstore.entity.Author;

public interface AuthorService {
	
	List<Author> getAllAuthors();
	
	Author saveAuthor(Author Author);
	
	Author getAuthorById(int id);
	
	Author updateAuthor(Author Author);
	
	void deleteAuthor(int id);
	
}
