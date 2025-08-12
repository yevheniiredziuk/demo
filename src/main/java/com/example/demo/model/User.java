package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String name;

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
