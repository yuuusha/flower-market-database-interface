package com.yusha.flowermarket.dto;

public record UserCredentials(String user_login, String user_password, String user_role) {
    public boolean isAdmin() {
        return user_role.equals("ADMIN");
    }
}
