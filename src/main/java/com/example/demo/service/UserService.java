package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void add(User user) {
        userRepository.add(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void remove(long id) {
        userRepository.remove(id);
    }

    public User getById(long id) {
        return userRepository.getById(id);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }
}
