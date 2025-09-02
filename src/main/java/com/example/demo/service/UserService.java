package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepositoryInMemory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class UserService {
    private final UserRepositoryInMemory userRepositoryInMemory;

    public void add(User user) {
        userRepositoryInMemory.add(user);
    }

    public void update(User user) {
        userRepositoryInMemory.update(user);
    }

    public void remove(long id) {
        userRepositoryInMemory.remove(id);
    }

    public User getById(long id) throws UserNotFoundException {
        User user = userRepositoryInMemory.getById(id);
        if(user == null) {
            throw new UserNotFoundException(String.format("user with id %d not found", id));
        }
        return user;
    }

    public Collection<User> getAll() {
        return userRepositoryInMemory.getAll();
    }

}
