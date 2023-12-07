package com.br.receitex_auth.service;

import com.br.receitex_auth.models.UserBaseModel;
import com.br.receitex_auth.models.UserRole;
import com.br.receitex_auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    MedicoService medicoService;
    @Autowired
    PacienteService pacienteService;

    @Autowired
    UserRepository repository;

    public record UserRequestDTO(String first_name, String last_name, String user_name, String password, UserRole role){}
    public record UserResponsetDTO(UUID id, UserRole role_user){}

    public String getFullNameUser(UUID id){
        UserBaseModel user = repository.findById(id).get();
        String fullName = user.getFirstName() + " " + user.getLastName();
        return fullName;
    }

    public UserRole getRoleUser(UUID userId) {
        UserBaseModel user = repository.findById(userId).get();
        return user.getRole();
    }

    public UserBaseModel saveUser(UserRequestDTO user){
        UserBaseModel newUser = null;

        switch (user.role){
            case DOCTOR:
                newUser = medicoService.createMedico(new MedicoService.MedicoRequestDTO(user.first_name, user.last_name));
                break;
            case PHARM: break;
            case PATIENT: newUser = pacienteService.createPaciente(new PacienteService.PacienteRequestDTO(user.first_name, user.last_name));
            break;

        }
        return newUser;

    }
}
