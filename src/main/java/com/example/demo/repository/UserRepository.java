package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.Collection;

public interface UserRepository {
    void add(User user);

    void update(User user);

    void remove(long id);

    User getById(long id);

    Collection<User> getAll();
}
