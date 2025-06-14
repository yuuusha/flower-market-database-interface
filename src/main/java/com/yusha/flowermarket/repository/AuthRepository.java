package com.yusha.flowermarket.repository;

import com.yusha.flowermarket.dto.AuthorizeUserRequest;
import com.yusha.flowermarket.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthRepository {

    private final JdbcClient client;

    public Integer performLogin(AuthorizeUserRequest authorizeUserRequestDTO) {
        return client.sql("SELECT users_id FROM users WHERE user_login = :login AND user_password = :password")
                .param("login", authorizeUserRequestDTO.getlogin())
                .param("password", authorizeUserRequestDTO.getPassword())
                .query(Integer.class)
                .single();
    }

    public String getEncodedPasswordByLogin(String login) {
        return client.sql("SELECT user_password FROM users WHERE user_login = :login")
                .param("login", login)
                .query(String.class)
                .single();
    }

    public Integer getUserIdByLogin(String login) {
        return client.sql("SELECT users_id FROM users WHERE user_login = :login")
                .param("login", login)
                .query(Integer.class)
                .single();
    }

    public User getUserById(Integer users_id) {
        return client.sql("SELECT Users_id, user_login, user_role FROM users WHERE Users_id = :users_id")
                .param("users_id", users_id)
                .query(User.class)
                .single();
    }

}
