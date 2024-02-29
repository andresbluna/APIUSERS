package com.api.apirestuser.repository;

import com.api.apirestuser.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserModel, String>{

    boolean existsByEmail(String email);

    User findByUsername(String username);
}
