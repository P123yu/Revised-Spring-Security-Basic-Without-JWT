package com.newSecurity.NewSecurity.repository;


import com.newSecurity.NewSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameOrEmail(String username, String email);
}
