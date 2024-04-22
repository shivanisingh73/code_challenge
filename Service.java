package com.example.demo.service;

import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getTopPerformingAuthors() {
        return authorRepository.findTopPerformingAuthors();
    }

    public Object getSalesByAuthor(String authorName) throws Exception {
        List<Author> results = authorRepository.findSalesByAuthor(authorName);
        if (results.isEmpty()) {
            throw new Exception("Author not found or no sales for this author.");
        }
        return results.get(0);
    }
}
