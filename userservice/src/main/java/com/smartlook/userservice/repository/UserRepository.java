package com.smartlook.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartlook.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public User findByEmail(String email);
}
