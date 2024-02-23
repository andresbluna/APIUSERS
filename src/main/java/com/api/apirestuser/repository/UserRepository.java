package com.api.apirestuser.repository;

import com.api.apirestuser.model.UserModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserModel, String>{

}
