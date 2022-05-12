package com.example.unifiedplatform.repository;

import com.example.unifiedplatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);

    User findByTelephone(String telephone);
}
