package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
//@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("/delete")
    public void remove(@RequestParam long id) {
        userService.remove(id);
    }

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable long id) {
        return userService.getById(id);
    }


    @GetMapping("/getAll")
    public Collection<User> getAll() {
        return userService.getAll();
    }
}

/*
# Отримати всіх користувачів (GET)
curl --request GET http://localhost:8080/users/getAll

# Додати нового користувача (POST)
curl --header "Content-Type: application/json" \
     --request POST \
     --data '{"id":"1","name":"Bob"}' \
     http://localhost:8080/users/add

# Отримати користувача за ID (GET)
curl --request GET http://localhost:8080/users/getById/1

# Оновити користувача (PUT)
curl --header "Content-Type: application/json" \
     --request PUT \
     --data '{"id":"1","name":"John"}' \
     http://localhost:8080/users/update

# Видалити користувача за ID (DELETE)
curl --request DELETE 'http://localhost:8080/users/delete?id=1'



 */