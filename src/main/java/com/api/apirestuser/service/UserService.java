package com.api.apirestuser.service;

import com.api.apirestuser.model.UserModel;
import com.api.apirestuser.repository.UserRepository;
import com.api.apirestuser.utils.UserException;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel userModel) {
        userModel.setCreated(LocalDateTime.now().toString());
        userModel.setModified(LocalDateTime.now().toString());
        userModel.setToken(generateToken());
        userModel.setLast_login(LocalDateTime.now().toString());
        return userRepository.save(userModel);
    }


    private String generateToken() {
        // Implementa la lógica para generar un token único
        return UUID.randomUUID().toString();
    }

    public UserModel getUserById(String id) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new
                UserException("El usuario con la " + id + " no existe "));
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
