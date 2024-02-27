package com.api.apirestuser.service;

import com.api.apirestuser.model.UserModel;
import com.api.apirestuser.repository.UserRepository;
import com.api.apirestuser.utils.UserException;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel createUser(UserModel userModel) {
        if (userRepository.existsByEmail(userModel.getEmail())) {
            throw new EntityExistsException("El correo electrónico ya está registrado.");
        }
        userModel.updateTimestamps();
        userModel.generateToken();
        return userRepository.save(userModel);
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
