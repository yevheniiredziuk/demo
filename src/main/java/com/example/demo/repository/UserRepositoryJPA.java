package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryJPA extends CrudRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findUserById(Long id);
}
