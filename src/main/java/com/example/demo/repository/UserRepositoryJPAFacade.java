package com.example.demo.repository;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@AllArgsConstructor
@ConditionalOnProperty(name = "data.store.type", havingValue = "JPA")
public class UserRepositoryJPAFacade  implements UserRepository {

    private UserRepositoryJPA userRepositoryJPA;
    @Override
    public void add(User user) {
        userRepositoryJPA.save(user);
    }

    @Override
    public void update(User user) {
        userRepositoryJPA.save(user);
    }

    @Override
    public void remove(long id) {
        userRepositoryJPA.deleteById(id);
    }

    @Override
    public User getById(long id) {
        return userRepositoryJPA.findById(id)
                 .orElseThrow(() -> new UserNotFoundException(String.format("User with id %d not found", id)));
    }

    @Override
    public Collection<User> getAll() {
        return (Collection<User> ) userRepositoryJPA.findAll()  ;
    }
}
