package com.example.CourseWork4.main.repository;

import com.example.CourseWork4.main.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findUserByName(String username);

}
