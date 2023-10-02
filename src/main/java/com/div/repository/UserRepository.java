package com.div.repository;

import com.div.model.entity.Role;
import com.div.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail (String email);
    User findByUuid (UUID uuid);
    User findByRole (Role role);

    boolean existsByEmail(String username);
}
