package com.springboot.bookstore.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.springboot.bookstore.entity.Author;
import com.springboot.bookstore.repository.AuthorRepository;
import com.springboot.bookstore.service.AuthorService;

@Service 
public class AuthorSericeImpl implements AuthorService{
    
    private final AuthorRepository authorRepository;

    public AuthorSericeImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author Author) {
        return authorRepository.save(Author);
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public Author updateAuthor(Author Author) {
        return authorRepository.save(Author);
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
        
    }
    
}
