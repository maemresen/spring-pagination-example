package com.maemresen.springpaginationexample.repository;

import com.maemresen.springpaginationexample.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT DISTINCT b FROM Book b LEFT JOIN b.chapters AS bc WHERE bc.read IS FALSE")
    Page<Book> getDistinctWithoutCustomCountQuery(Pageable pageable);

    @Query("SELECT b FROM Book b LEFT JOIN b.chapters AS bc WHERE bc.read IS FALSE")
    Page<Book> getWithoutCustomCountQuery(Pageable pageable);

    @Query(
            value = "SELECT b FROM Book b LEFT JOIN b.chapters AS bc WHERE bc.read IS FALSE",
            countQuery = " SELECT COUNT(b) FROM Book b")
    Page<Book> getWithCustomCountQuery(Pageable pageable);
}
