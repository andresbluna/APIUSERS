package com.api.apirestuser.model;


import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.Scanner;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RestController
@ResponseBody
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private String username;

    private String name;

    private String surname;

    private String direction;

    private String location;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<UserPhones> phones;
    private String created;
    private String modified;
    private String token;
    private String last_login;
    private boolean isactive;

    @PrePersist
    public void onPrePersist() {
        created = LocalDateTime.now().toString();
        modified = created;
        last_login = created;
    }

    @PreUpdate
    public void onPreUpdate() {
        modified = LocalDateTime.now().toString();
    }

    public String getIsactive() {
        return isactive ? "no" : "si";
    }

    public void setIsactive(String isactive) {
        this.isactive = "no".equalsIgnoreCase(isactive);
    }

}
