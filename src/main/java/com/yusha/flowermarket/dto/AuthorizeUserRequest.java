package com.yusha.flowermarket.dto;

public record AuthorizeUserRequest(String login, String password) {
    public String getlogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
