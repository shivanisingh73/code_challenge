package com.example.demo.controller;

import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors/top-sales")
    public ResponseEntity<List<Authors>> getTopPerformingAuthors(@RequestParam(required = false) String authorName) {
        try {
            if (authorName != null) {
                return ResponseEntity.ok(authorService.getSalesByAuthor(authorName));
            } else {
                return ResponseEntity.ok(authorService.getTopPerformingAuthors());
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
