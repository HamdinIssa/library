package com.example.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.library.entity.Book;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("SELECT b FROM Book b WHERE b.bookName LIKE %?1% OR b.booksAuthor LIKE %?1% OR b.booksPublisher LIKE %?1%")
    List<Book> findByBookName(String keyword);

}
