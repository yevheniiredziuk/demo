package com.example.demo.repository;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@AllArgsConstructor
@ConditionalOnProperty(name="data.store.type", havingValue = "JDBC ")
public class UserRepositoryJDBC implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    public void add(User user) {
        String sql = "INSERT INTO user (name) VALUES (?)";
        jdbcTemplate.update(sql, user.getName());
    }

     public User getById(long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},
                BeanPropertyRowMapper.newInstance(User.class));
     }

     public Collection<User> getAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
     }

     public  void update(User user) {
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getId());
     }

     public void remove(long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql, id);
     }


}
