package com.yusha.flowermarket.service;

import com.yusha.flowermarket.config.jwt.JWTToken;
import com.yusha.flowermarket.config.jwt.JWTUtil;
import com.yusha.flowermarket.dto.User;
import com.yusha.flowermarket.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    private final PasswordEncoder passwordEncoder;

    private final JWTUtil jwtUtil;

    @Transactional
    public JWTToken performLogin(String login, String password) {
        String encodedPasswordFromDB = authRepository.getEncodedPasswordByLogin(login);

        if (passwordEncoder.matches(password, encodedPasswordFromDB)) {
            Integer userId = authRepository.getUserIdByLogin(login);
            User user = authRepository.getUserById(userId);
            String token = jwtUtil.generateToken(userId, login, user.user_role());
            return new JWTToken(token);
        } else {
            throw new RuntimeException();
        }
    }

}
