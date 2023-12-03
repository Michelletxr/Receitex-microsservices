package com.br.receitex_auth.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;
@Entity
@NoArgsConstructor
@ToString(exclude = {"password"})
@Table(name = "auth", schema = "public")
@Data
public class AuthModel implements UserDetails {
    //informações de  autentificação
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String userName;
    String password;
    //referencia para id do usuario
    UUID user_id;

    @Builder
    public AuthModel(String userName, String password, UUID user_id){
        this.userName = userName;
        this.password = password;
        this.user_id = user_id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
