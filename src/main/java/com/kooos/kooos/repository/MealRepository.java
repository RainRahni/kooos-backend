package com.kooos.kooos.repository;

import com.kooos.kooos.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
