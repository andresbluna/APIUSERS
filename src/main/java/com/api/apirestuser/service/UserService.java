package com.api.apirestuser.service;

import com.api.apirestuser.model.UserModel;
import com.api.apirestuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel createUser(UserModel userModel){
        userModel.setId(UUID.randomUUID().toString());


        
        return userRepository.save(userModel);

    }

    public UserModel getUserById(String id){
        Optional<UserModel> optionalUser = userRepository.findById(id);
        return optionalUser.get();

    }

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();

    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

}
