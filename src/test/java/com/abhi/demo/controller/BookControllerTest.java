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
    book.setName("Effective Java");
    book.setAuthor("Joshua");
    book.setPublisher("Unknown");
    Set<Book> books = Collections.singleton(book);
    when(service.getAll()).thenReturn(books);
    mockMvc.perform(get("/books")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[0].name").value("Effective Java")).andExpect(
        jsonPath("$[0].author").value("Joshua"))
        .andExpect(jsonPath("$[0].publisher").value("Unknown"));
  }

  @Test
  public void testGet() throws Exception {
    Book book = new Book();
    book.setId(1);
    book.setName("Harry Potter I");
    book.setAuthor("J.K Rowling");
    book.setPublisher("Unknown");
    when(service.get(anyLong())).thenReturn(book);
    mockMvc.perform(get("/books/1")).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Harry Potter I")).andExpect(
        jsonPath("$.author").value("J.K Rowling"))
        .andExpect(jsonPath("$.publisher").value("Unknown"));
  }
}
