package com.yusha.flowermarket.controller;

import com.yusha.flowermarket.config.jwt.JWTToken;
import com.yusha.flowermarket.dto.AuthorizeUserRequest;
import com.yusha.flowermarket.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public JWTToken performLogin(@RequestBody AuthorizeUserRequest request) {
        return authService.performLogin(request.login(), request.password());
    }
}
