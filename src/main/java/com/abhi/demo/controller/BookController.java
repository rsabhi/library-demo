package com.abhi.demo.controller;

import com.abhi.demo.entity.Book;
import com.abhi.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  BookService bookService;

  @GetMapping
  public Iterable<Book> getAll() {
    return bookService.getAll();
  }

  @GetMapping("/{id}")
  public Book getOne(@PathVariable long id) {
    return bookService.get(id);
  }

  @PostMapping()
  public Book save(@RequestBody Book book) {
    return bookService.save(book);
  }

  @PostMapping("/batch")
  public Iterable<Book> batchSave(@RequestBody Iterable<Book> books) {
    return bookService.batchSave(books);
  }
}
