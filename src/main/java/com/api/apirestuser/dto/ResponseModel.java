package com.api.apirestuser.dto;

import com.api.apirestuser.model.UserPhones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

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

    public ResponseModel(Map<String, String> errorResponse, HttpStatus httpStatus) {

    }
}
