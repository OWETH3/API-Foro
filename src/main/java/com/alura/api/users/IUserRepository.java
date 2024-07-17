package com.alura.api.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepository extends JpaRepository<users, Long> {
    UserDetails findBylogin(String username);
}
