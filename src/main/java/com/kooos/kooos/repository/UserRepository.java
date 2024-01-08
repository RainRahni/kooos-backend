package com.kooos.kooos.repository;

import com.kooos.kooos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
