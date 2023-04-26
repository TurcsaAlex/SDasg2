package com.example.asgn2.model.repos;

import com.example.asgn2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    Optional<User> findById(Integer uuid);

    Optional<User> findByEmail(String email);
}
