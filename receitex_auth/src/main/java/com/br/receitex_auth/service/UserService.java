package com.br.receitex_auth.service;

import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.models.UserBaseModel;
import com.br.receitex_auth.models.UserRole;
import com.br.receitex_auth.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.br.receitex_auth.models.UserRole.DOCTOR;
import static com.br.receitex_auth.models.UserRole.PATIENT;

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
        String fullName = user.getFirstName() + " " + user.getLastName();;
        return fullName;
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
