package com.api.apirestuser.service;

import com.api.apirestuser.model.UserModel;
import com.api.apirestuser.repository.UserRepository;
import com.api.apirestuser.utils.ErrorMsg;
import com.api.apirestuser.utils.ErrorResponse;
import com.api.apirestuser.utils.UserException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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



    public ResponseEntity<?> registerUser(UserModel userModel) {
        try {
            // Validar el formato del correo electrónico utilizando la regex
            if (!validMail(userModel.getEmail())) {
                ErrorResponse errorResponse = new ErrorResponse("error01", String.format("El correo electrónico %s no es válido", userModel.getEmail()));
                return new ResponseEntity<>(errorResponse.toMap(), HttpStatus.BAD_REQUEST);
            }

            // Intentar crear el usuario
            UserModel savedUser = createUser(userModel);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (ValidationException e) {
            // Capturar excepción de validación y devolver un mensaje de error
            String errorMessage = e.getMessage();
            ErrorResponse errorResponse = new ErrorResponse("error01", errorMessage);
            return new ResponseEntity<>(errorResponse.toMap(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Capturar otras excepciones y devolver un mensaje de error genérico
            ErrorResponse errorResponse = new ErrorResponse("error01", "Error desconocido al procesar la solicitud");
            return new ResponseEntity<>(errorResponse.toMap(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public UserModel createUser(UserModel userModel) {
        userModel.setCreated(LocalDateTime.now().toString());
        userModel.setModified(LocalDateTime.now().toString());
        userModel.setToken(generateToken());
        userModel.setLast_login(LocalDateTime.now().toString());

        return userRepository.save(userModel);
    }


    private String generateToken() {
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

    //Método para validar email

    public boolean validMail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_" +
                "+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }





}
