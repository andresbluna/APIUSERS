package com.api.apirestuser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phones")
public class UserPhones {

        @JsonIgnore
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String number;

        private String citycode;

        public String countrycode;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserModel user;
        private String created;
        private String modified;
        private String token;
        private String last_login;
        private String isactive;

    }
