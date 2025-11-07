package com.oas.sdproject.repository;

import com.oas.sdproject.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<User> userMapper = (rs, rowNum) ->
            new User(
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phone_number")
            );

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT user_id, first_name, last_name FROM users", userMapper);
    }
}
