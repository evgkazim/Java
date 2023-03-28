package ru.kazim.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kazim.security.entity.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findByUsername(String username);
}
