package com.api.apirestuser.controller;

import com.api.apirestuser.dto.ResponseModel;
import com.api.apirestuser.model.UserModel;
import com.api.apirestuser.repository.UserRepository;
import com.api.apirestuser.service.UserService;
import com.api.apirestuser.utils.ResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {
        if (userRepository.existsByEmail(userModel.getEmail())) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error01", String.format
                    ("El correo electrónico %s ya está registrado", userModel.getEmail()));
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        UserModel savedUser = userRepository.save(userModel);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
   /* @GetMapping
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

}*/
