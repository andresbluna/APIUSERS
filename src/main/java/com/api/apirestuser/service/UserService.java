package com.api.apirestuser.service;

import com.api.apirestuser.model.UserModel;
import com.api.apirestuser.repository.UserRepository;
import com.api.apirestuser.utils.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel userModel) {
        userModel.updateTimestamps();
        userModel.generateToken();
        return userRepository.save(userModel);
    }

    public UserModel getUserById(String id) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new
                UserException("User with id " + id + "not found"));
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
