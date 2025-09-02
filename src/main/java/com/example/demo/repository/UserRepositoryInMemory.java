package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@ConditionalOnProperty(name="data.store.type", havingValue = "IN_MEMORY")
public class UserRepositoryInMemory implements UserRepository {
    private static final Map<Long, User> USERS = new HashMap<>();

    public void add(User user) {
         USERS.put(user.getId(), user);
     }

    public void update(User user) {
        USERS.computeIfPresent(user.getId(), (k, v) -> user);
    }

    public void remove(long id) {
         USERS.remove(id);
    }

    public User getById(long id) {
         return USERS.get(id);
    }

    public Collection<User> getAll() {
         return USERS.values();
    }
}
