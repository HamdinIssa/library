package com.example.library.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entity.Book;
import com.example.library.exception.NotFoundException;
import com.example.library.repository.BookRepository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookServiceImpl implements BookService{
    final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        return bookRepository.findById(theId)
                .orElseThrow(() -> new NotFoundException(String.format(" not found  with ID %d", theId)));
    }

    @Override
    public void save(Book theBook) {

        bookRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }

    @Override
    public List<Book> findBookByName(String keyword) {
        return bookRepository.findByBookName(keyword);
    }

 
}
