package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("SELECT a.name, SUM(si.itemPrice * si.quantity) AS totalRevenue " +
           "FROM Author a JOIN a.books b JOIN b.saleItems si " +
           "GROUP BY a.name ORDER BY totalRevenue DESC")
    List<List<Author>> findTopPerformingAuthors();

    @Query("SELECT a.name, SUM(si.itemPrice * si.quantity) AS totalRevenue " +
           "FROM Author a JOIN a.books b JOIN b.saleItems si " +
           "WHERE a.name = :authorName " +
           "GROUP BY a.name ORDER BY totalRevenue DESC")
    List<List<Author>> findSalesByAuthor(String authorName);
}