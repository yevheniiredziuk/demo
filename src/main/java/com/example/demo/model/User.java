package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class User {
    private long id;
    private String name;

    public User(){
    }
}
