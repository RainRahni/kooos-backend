package com.kooos.kooos.repository;

import com.kooos.kooos.model.Meal;
import com.kooos.kooos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
