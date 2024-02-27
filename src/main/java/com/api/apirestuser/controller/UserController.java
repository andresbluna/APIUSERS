package com.api.apirestuser.controller;

import com.api.apirestuser.dto.ResponseModel;
import com.api.apirestuser.model.UserModel;
import com.api.apirestuser.repository.UserRepository;
import com.api.apirestuser.service.UserService;
import com.api.apirestuser.utils.ResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResponseConverter converter;

    @PostMapping
    public ResponseModel createUser(@RequestBody UserModel userModel) {
        UserModel savedUser = userService.createUser(userModel);
        return converter.convert(savedUser);
    }
    @GetMapping
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserModel searchUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable String id){
        userService.deleteUser(id);
    }

}
