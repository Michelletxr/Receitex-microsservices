package com.br.receitex_auth.controller;

import com.br.receitex_auth.config.TokenConfig;
import com.br.receitex_auth.model.User;
import com.br.receitex_auth.model.UserRole;
import com.br.receitex_auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenConfig tokenConfig;

    @Autowired
    private UserRepository repository;

    record AUthDTO(String username, String password){}
    record UserLoginDTO(String token){}
    record UserRequestDTO(String username, String password, UserRole role){}
    record UserResponsetDTO(UUID id, UserRole role_user){}

    //gerar token de acesso
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AUthDTO auth){
        var usernamePassword = new UsernamePasswordAuthenticationToken(auth.username(), auth.password());
        var authData = authenticationManager.authenticate(usernamePassword);
        var token = tokenConfig.generateToken((User) authData.getPrincipal());
        return ResponseEntity.ok(new UserLoginDTO(token));
    }

    //criar usuário
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRequestDTO registerData){
        // validar username
        if(repository.findByUserName(registerData.username) != null) return ResponseEntity.badRequest().build();
        // encriptografar senha
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerData.password());
        User newUser = new User(registerData.username(), encryptedPassword, registerData.role());
        repository.save(newUser);
        return ResponseEntity.ok(new UserResponsetDTO(newUser.getId(), newUser.getUserRole()));
    }
}
