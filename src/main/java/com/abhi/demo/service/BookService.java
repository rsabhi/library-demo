package com.abhi.demo.service;

import com.abhi.demo.entity.Book;
import com.abhi.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  BookRepository repository;

  public Book save(Book book) {
    return repository.save(book);
  }

  public Iterable<Book> batchSave(Iterable<Book> books) {
    return repository.save(books);
  }

  public Book get(long id) {
    return repository.findOne(id);
  }

  public Iterable<Book> getAll() {
    return repository.findAll();
  }
}
