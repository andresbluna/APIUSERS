package com.api.apirestuser.dto;

import com.api.apirestuser.model.UserPhones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ResponseModel {

    private String id;
    private String name;
    private String email;
    private String password;
    private List<UserPhones> phones;
    private String created;
    private String modified;
    private String token;
    private String last_login;
    private String isactive;

}
