package com.br.receitex_auth.service;

import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.models.UserBaseModel;
import com.br.receitex_auth.models.UserRole;
import com.br.receitex_auth.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    MedicoRepository medicoRepository;

    public record UserRequestDTO(String first_name, String last_name, String user_name, String password, UserRole role){}
    public record UserResponsetDTO(UUID id, UserRole role_user){}

    public UserBaseModel saveUser(UserRequestDTO user){
        UserBaseModel newUser = null;
        if(user.role == UserRole.DOCTOR){
            newUser = medicoRepository.save(new Medico());
        }
        return newUser;

    }
}
