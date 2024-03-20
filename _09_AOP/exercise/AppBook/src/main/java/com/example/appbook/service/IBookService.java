package com.example.appbook.service;

import com.example.appbook.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Long id);
}
