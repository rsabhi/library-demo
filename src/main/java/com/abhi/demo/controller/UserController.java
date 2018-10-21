package com.abhi.demo.controller;

import com.abhi.demo.entity.User;
import com.abhi.demo.service.UserService;
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
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService service;

  @GetMapping
  public Iterable<User> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public User getOne(@PathVariable long id) {
    return service.get(id);
  }

  @PostMapping
  public User save(@RequestBody User user) {
    return service.save(user);
  }

  @PostMapping("/batch")
  public Iterable<User> batchSave(@RequestBody Iterable<User> users) {
    return service.batchSave(users);
  }
}
