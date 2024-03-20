package com.example.appbook.service.impl;

import com.example.appbook.model.Book;
import com.example.appbook.repository.IBookRepository;
import com.example.appbook.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return iBookRepository.findById(id).orElse(null);
    }
}
