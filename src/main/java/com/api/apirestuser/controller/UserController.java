package com.api.apirestuser.controller;

import com.api.apirestuser.model.UserModel;
import com.api.apirestuser.repository.UserRepository;
import com.api.apirestuser.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@OpenAPIDefinition
@RestController
@RequestMapping("api/users")
public class UserController {

    //CRUD = CREATE READ UPDATE DELETE

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserModel userModel) {
        return userService.registerUser(userModel);
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserModel searchUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable String id) {
        userService.deleteUser(id);
    }
}