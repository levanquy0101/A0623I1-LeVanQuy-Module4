package com.example.validateregister.service;

import com.example.validateregister.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);

    User findById(int id);

    void update(User user);

    void delete(Long id);
}
