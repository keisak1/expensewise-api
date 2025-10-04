package com.nuno.expensewiseapi.repository;

import com.nuno.expensewiseapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findByName(String name);
    boolean existsByEmail(String email);
    boolean existsByName(String name);

}
