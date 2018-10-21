package com.abhi.demo.controller;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.abhi.demo.entity.Book;
import com.abhi.demo.service.BookService;
import java.util.Collections;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class, secure = false)
public class BookControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BookService service;

  @Test
  public void testGetAll() throws Exception {
    Book book = new Book();
    book.setId(1);
    book.setName("Effective database");
    book.setAuthor("ManuRS");
    book.setISBN("1212121234");
    Set<Book> books = Collections.singleton(book);
    when(service.getAll()).thenReturn(books);
    mockMvc.perform(get("/books")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[0].name").value("Effective database")).andExpect(
        jsonPath("$[0].author").value("ManuRS"))
        .andExpect(jsonPath("$[0].isbn").value("1212121234"));
  }

  @Test
  public void testGet() throws Exception {
    Book book = new Book();
    book.setId(1);
    book.setName("Harry Potter I");
    book.setAuthor("J.K Rowling");
    book.setISBN("8766665544");
    when(service.get(anyLong())).thenReturn(book);
    mockMvc.perform(get("/books/1")).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Harry Potter I")).andExpect(
        jsonPath("$.author").value("J.K Rowling"))
        .andExpect(jsonPath("$.isbn").value("8766665544"));
  }
}
