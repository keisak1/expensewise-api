package com.nuno.expensewiseapi.repository;

import com.nuno.expensewiseapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);
    boolean existsByEmail(String email);
    boolean existsByName(String name);

}
