package com.example.library.service;


import com.example.library.entity.Book;

import java.util.List;


public interface BookService {
     default List<Book> findAll() {
        
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

     default Book findById(int theId) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

     default void save(Book theBook) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

     default void deleteById(int theId) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

     default List<Book> findBookByName(String keyword) {
        throw new UnsupportedOperationException("Unimplemented method 'findBookByName'");
    }
}
