package com.tienda.api.repositories;

import com.tienda.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Al llamarse "findBy" + "Email", Spring sabe que debe hacer un:
    // SELECT * FROM USUARIOS WHERE EMAIL = ?
    Optional<User> findByEmail(String email);
}
