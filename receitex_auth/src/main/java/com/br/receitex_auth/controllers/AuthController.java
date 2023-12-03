package com.br.receitex_auth.controllers;

import com.br.receitex_auth.config.TokenConfig;
import com.br.receitex_auth.models.AuthModel;
import com.br.receitex_auth.models.UserBaseModel;
import com.br.receitex_auth.repositories.AuthRepository;
import com.br.receitex_auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenConfig tokenConfig;
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private UserService userService;
    record AuthRequestDTO(String user_name, String password){}
    record AuthResponseDTO(UUID auth_id, String user_name){}
    record UserLoginDTO(String token){}

    //gerar token de acesso
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthRequestDTO auth){
        var usernamePassword = new UsernamePasswordAuthenticationToken(auth.user_name(), auth.password());
        var authData = authenticationManager.authenticate(usernamePassword);
        var token = tokenConfig.generateToken((AuthModel) authData.getPrincipal());
        return ResponseEntity.ok(new UserLoginDTO(token));
    }

    //criar usuário e autentificar
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserService.UserRequestDTO registerData){
        // validar username
        if(authRepository.findByUserName(registerData.user_name()) != null) return ResponseEntity.badRequest().build();

        // encriptografar senha
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerData.password());

        //salvar usuario
        UserBaseModel newUser = userService.saveUser(registerData);

        //salvar autentificação do usuario
        AuthModel auth = authRepository.save(new AuthModel(registerData.user_name(), encryptedPassword, newUser.getId()));
        return ResponseEntity.ok(new AuthResponseDTO(auth.getId(), auth.getUsername()));
    }
}
