package com.tienda.api.controllers;

import com.tienda.api.dtos.LoginRequest;
import com.tienda.api.entities.User;
import com.tienda.api.services.JwtService;
import com.tienda.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            // Ejecutamos la lógica de login
            User user = userService.login(request.getEmail(), request.getPassword());

            String token = jwtService.generateToken(user);

            return ResponseEntity.ok(Map.of("token", token));

        } catch (RuntimeException e) {
            // Si algo falla (usuario no existe o clave mal), devolvemos un error 401 (Unauthorized)
            // Equivalente a return Unauthorized(e.Message) en C#
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", e.getMessage()));
        }
    }
}
