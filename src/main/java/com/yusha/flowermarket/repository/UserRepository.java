package com.yusha.flowermarket.repository;

import com.yusha.flowermarket.dto.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcClient client;

    public UserCredentials findByLogin(String login) {
        return client.sql("SELECT user_login, user_password, user_role FROM Users WHERE user_login = :user_login")
                .param("user_login", login)
                .query(UserCredentials.class)
                .single();
    }
}
