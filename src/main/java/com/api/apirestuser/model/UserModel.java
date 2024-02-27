package com.api.apirestuser.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<UserPhones> phones;

    // Campos adicionales para la respuesta
    private String created;
    private String modified;
    private String token;
    private String last_login;
    private String isactive;

    // Método para actualizar la fecha de creación y modificación
    public void updateTimestamps() {
        this.created = LocalDateTime.now().toString();
        this.modified = LocalDateTime.now().toString();
    }

    // Método para generar un token
    public void generateToken() {
        this.token = UUID.randomUUID().toString();
    }

}
