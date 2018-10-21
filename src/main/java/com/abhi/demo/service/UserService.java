package com.abhi.demo.service;

import com.abhi.demo.entity.User;
import com.abhi.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository repository;

  public User save(User user) {
    return repository.save(user);
  }

  public Iterable<User> batchSave(Iterable<User> users) {
    return repository.save(users);
  }

  public User get(long id) {
    return repository.findOne(id);
  }

  public Iterable<User> getAll() {
    return repository.findAll();
  }
}
