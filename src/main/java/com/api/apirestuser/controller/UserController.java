package com.api.apirestuser.controller;

import com.api.apirestuser.model.UserModel;
import com.api.apirestuser.repository.UserRepository;
import com.api.apirestuser.service.UserService;
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

    //POST para persistir el usuario
    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel) {
        UserModel savedUser = userRepository.save(userModel);
        return savedUser;
    }
    //GET para recuperar la lista de usuarios
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
